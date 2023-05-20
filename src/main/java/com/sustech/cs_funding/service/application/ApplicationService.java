package com.sustech.cs_funding.service.application;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.common.SendEmail;
import com.sustech.cs_funding.entity.Application;
import com.sustech.cs_funding.entity._ApplicationWithApplicant;
import com.sustech.cs_funding.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    ApplicationMapper applicationMapper;
    @Autowired
    ExpenseCategoryMapper expenseCategoryMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    FundingMapper fundingMapper;
    @Autowired
    NotificationMapper notificationMapper;

    public Result applyFunding(Integer id, String fundName, String applicant_id, String group, Double money, String first_category, String second_category, String abstracts, String remarks, String status) {
        Integer categoryID = expenseCategoryMapper.getCategoryID(first_category, second_category);
        // id == -1, insert new one without draft
        //
        if (id < 0) {
            applicationMapper.insertApp(fundName, Integer.parseInt(applicant_id), group, money, categoryID, abstracts, remarks);
        }
        else if (status.equals("draft")) {
            applicationMapper.deleteApplicationById(id);
            applicationMapper.insertApp(fundName, Integer.parseInt(applicant_id), group, money, categoryID, abstracts, remarks);
        }
        else
            applicationMapper.updateApp(id, fundName, money, categoryID, abstracts, remarks);
        //Todo:后续要改
        String adminEmail = userMapper.getAdminEmail("CSE");
        String message = "From group " + group + ",\nthere are a new application for funding " + fundName;
        try {
            SendEmail.sendMail(adminEmail, "New Funding Application", message);
            Date date = new Date(); // this object contains the current date value
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = formatter.format(date);
            System.out.println(formatter.format(date));
            notificationMapper.insertNotification(Integer.parseInt(applicant_id), message, time);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Result.ok().code(200).message("Success");
    }

    public Result applyFundingDraft(Integer id, String fundName, String applicant_id, String group, Double money, String first_category, String second_category, String abstracts, String remarks) {
        Integer categoryID = expenseCategoryMapper.getCategoryID(first_category, second_category);
        applicationMapper.insertAppDraft(fundName, Integer.parseInt(applicant_id), group, money, categoryID, abstracts, remarks);
        return Result.ok().code(200).message("Success");
    }

    public Result updateResult(Integer id, String result, String comment) {
        applicationMapper.updateResult(id, result, comment);
        Application application = applicationMapper.getApplicationById(id);
        if (result.equals("pass")) {
            comment = "Your application for funding has been approved.\n"+"Comment: "+ comment;
            String group = application.getGroup_name();
            String fundName = application.getFund_name();
            Double money = application.getExpense();
            fundingMapper.updateFunding(group, fundName, money);
//            return Result.ok().code(200).message("Success").addData("apply",application);
        }
        else{
            comment = "Sorry, your application for funding has been refused.\n"+"Comment: "+ comment;
        }
        Integer user_id = application.getApplicant_id();
        try {
            SendEmail.sendMail(userMapper.getUserById(user_id).getEmail(), "Application Result", comment);
            Date date = new Date(); // this object contains the current date value
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = formatter.format(date);
            System.out.println(formatter.format(date));
            notificationMapper.insertNotification(0, comment, time);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Result.ok().code(200).message("Success");
    }

    public Result getTotalCount(String status) {
        if (status.equals("total")) {
            return Result.ok().code(200).message("Success").addData("totalCount", applicationMapper.getTotalCount("%"));
        } else {
            return Result.ok().code(200).message("Success").addData("totalCount", applicationMapper.getTotalCount(status));
        }
    }

    public Result getApplications(int limit, int offset, String status) {
        List<Application> applications;
        if (status.equals("total")) {
            applications = applicationMapper.getApplications(limit, offset, "%");
        } else {
            applications = applicationMapper.getApplications(limit, offset, status);
        }
        return joinApplicationWithApplicant(applications);
    }

    public Result getApplicationsByGroup(String group, int limit, int offset, String status) {
        List<Application> applications;
        if (status.equals("total")) {
            applications = applicationMapper.getApplicationsByGroup(group , limit, offset, "%");
        } else {
            applications = applicationMapper.getApplicationsByGroup(group, limit, offset, status);
        }
        return joinApplicationWithApplicant(applications);
    }

    private Result joinApplicationWithApplicant(List<Application> applications) {
        List<_ApplicationWithApplicant> _applicationWithApplicants = new ArrayList<>();
        for (Application a : applications) {
            _ApplicationWithApplicant _app = new _ApplicationWithApplicant();
            _app.setApplication(a);
            _app.setApplicant(userMapper.getUserById(a.getApplicant_id()));
            _app.setExpenseCategory(expenseCategoryMapper.getCategory(a.getExpense_category()));
            _applicationWithApplicants.add(_app);
        }
        return Result.ok().code(200).message("Success").addData("applications", _applicationWithApplicants);
    }
    
    public Result getApplicationCountByGroup(String group, String status) {
        if (status.equals("total")) {
            return Result.ok().code(200).message("Success").addData("totalCount", applicationMapper.getApplicationCountByGroup(group, "%"));
        } else {
            return Result.ok().code(200).message("Success").addData("totalCount", applicationMapper.getApplicationCountByGroup(group, status));
        }
    }

    public Result deleteApplicationByID(Integer id) {
        applicationMapper.deleteApplicationById(id);
        return Result.ok().code(200).message("Success");
    }
}
