package com.sustech.cs_funding.service.application;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.common.SendEmail;
import com.sustech.cs_funding.entity.Application;
import com.sustech.cs_funding.entity._ApplicationWithApplicant;
import com.sustech.cs_funding.mapper.ApplicationMapper;
import com.sustech.cs_funding.mapper.ExpenseCategoryMapper;
import com.sustech.cs_funding.mapper.FundingMapper;
import com.sustech.cs_funding.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Result applyFunding(String fundName, String applicant_id, String group, Double money, String first_category, String second_category, String abstracts, String remarks) {
        Integer categoryID = expenseCategoryMapper.getCategoryID(first_category, second_category);

        System.out.println(applicant_id);
        applicationMapper.applyFunding(fundName, Integer.parseInt(applicant_id), group, money, categoryID, abstracts, remarks);
        //Todo:后续要改
        String adminEmail = userMapper.getAdminEmail("CSE");
        String message = "From group " + group + ",\nthere are a new application for funding " + fundName;
        try {
            System.out.println(adminEmail);
            SendEmail.sendMail(adminEmail, "New Funding Application", message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Result.ok().code(200).message("Success");
    }

    public Result getTotalCount() {
        return Result.ok().code(200).message("Success").addData("totalCount", applicationMapper.getTotalCount());
    }

    public Result getApplications(int limit, int offset, String status) {
        int total = applicationMapper.getTotalCount();
        if (limit > total - offset) {
            return Result.error().code(300).message("Invalid limit and offset.");
        } else {
            List<Application> applications;
            if (status.equals("total")) {
                applications = applicationMapper.getApplications(limit, offset, "%");
            } else {
                applications = applicationMapper.getApplications(limit, offset, status);
            }
            List<_ApplicationWithApplicant> _applicationWithApplicants = new ArrayList<>();
            for (Application a : applications) {
                _ApplicationWithApplicant _app = new _ApplicationWithApplicant();
                _app.setApplication(a);
                _app.setApplicant(userMapper.getUserById(a.getApplicant_id()));
                _applicationWithApplicants.add(_app);
            }
            return Result.ok().code(200).message("Success").addData("applications", _applicationWithApplicants);
        }
    }
}
