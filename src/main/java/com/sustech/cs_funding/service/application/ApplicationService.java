package com.sustech.cs_funding.service.application;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.entity.Application;
import com.sustech.cs_funding.entity._ApplicationWithApplicant;
import com.sustech.cs_funding.mapper.ApplicationMapper;
import com.sustech.cs_funding.mapper.ExpenseCategoryMapper;
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
    public Result applyFunding(String fundName, String applicant_id, String group, Double money, String first_category, String second_category,String abstracts, String remarks){
        Integer categoryID = expenseCategoryMapper.getCategoryID(first_category, second_category);
//        Integer applicant_id = userMapper.getUserByName(applicant).getSid();
        System.out.println(applicant_id);
        applicationMapper.applyFunding(fundName, Integer.parseInt(applicant_id), group, money, categoryID,abstracts, remarks);
        return Result.ok().code(200).message("Success");
    }
    
    public Result updateResult(String id, String result, String comment) {
        applicationMapper.updateResult(id, result, comment);
        return Result.ok().code(200).message("Success");
    }

    public Result getTotalCount() {
        return Result.ok().code(200).message("Success").addData("totalCount", applicationMapper.getTotalCount());
    }
    
    public Result getApplications(int limit, int offset) {
        int total = applicationMapper.getTotalCount();
        if (limit > total - offset) {
            return Result.error().code(300).message("Invalid limit and offset.");
        } else {
            List<Application> applications = applicationMapper.getApplications(limit, offset);
            List<_ApplicationWithApplicant> _applicationWithApplicants = new ArrayList<>();
            for (Application a: applications) {
                _ApplicationWithApplicant _app = new _ApplicationWithApplicant();
                _app.setApplication(a);
                _app.setApplicant(userMapper.getUserById(a.getApplicant_id()));
                _applicationWithApplicants.add(_app);
            }
            return Result.ok().code(200).message("Success").addData("applications", _applicationWithApplicants);
        }
    }
}
