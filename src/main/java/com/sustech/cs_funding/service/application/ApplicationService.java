package com.sustech.cs_funding.service.application;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.mapper.ApplicationMapper;
import com.sustech.cs_funding.mapper.ExpenseCategoryMapper;
import com.sustech.cs_funding.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    @Autowired
    ApplicationMapper applicationMapper;
    @Autowired
    ExpenseCategoryMapper expenseCategoryMapper;
    @Autowired
    UserMapper userMapper;
    public Result applyFunding(String fundName, String applicant, String group, Double money, String category,String abstracts, String remarks){
        String[] categories = category.split(" / ");
        Integer categoryID = expenseCategoryMapper.getCategoryID(categories[0], categories[1]);
        System.out.println(applicant);
        System.out.println(userMapper.getUser(applicant).getSid());
        Integer applicant_id = userMapper.getUser(applicant).getSid();
        System.out.println(applicant_id);
        applicationMapper.applyFunding(fundName, applicant_id, group, money, categoryID,abstracts, remarks);
        return Result.ok().code(200).message("Success");
    }
    
    public Result updateResult(String id, String result) {
        applicationMapper.updateResult(id, result);
        return Result.ok().code(200).message("Success");
    }
}
