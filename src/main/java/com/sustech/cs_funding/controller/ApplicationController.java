package com.sustech.cs_funding.controller;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.service.application.ApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groups")
@CrossOrigin
@Api(tags = "接口测试")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService ;

    @GetMapping("/applyFunding")
    @ApiOperation(value = "Apply Funding")
    public Result applyFunding(String fundName, String applicant, String group, Double money, String category,String abstracts, String remarks) {
        return applicationService.applyFunding(fundName, applicant, group, money, category, abstracts, remarks);
    }
}
