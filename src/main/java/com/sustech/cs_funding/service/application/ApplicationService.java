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
    ExpenseCategoryMapper expenseCategoryMapper;
    UserMapper userMapper;
    public Result applyFunding(String fundName, String applicant, String group, String money, String category,String abstracts, String remarks){
        String[] categories = category.split("/");
        Integer categoryID = expenseCategoryMapper.getCategoryID(categories[0], categories[1]);
        Integer applicant_id = userMapper.getUser(applicant).getId();
        applicationMapper.applyFunding(fundName, applicant_id, group, money, categoryID,abstracts, remarks);
        return Result.ok().code(200).message("Success");
    }
}
