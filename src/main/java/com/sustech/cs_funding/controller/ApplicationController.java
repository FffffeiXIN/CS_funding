package com.sustech.cs_funding.controller;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.service.application.ApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apply")
@CrossOrigin
@Api(tags = "接口测试")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @PostMapping("/applyFunding")
    @ApiOperation(value = "Apply Funding")
    public Result applyFunding(String fundName, String applicant, String group, Double money, String first_category, String second_category, String abstracts, String remarks) {
        return applicationService.applyFunding(fundName, applicant, group, money, first_category, second_category, abstracts, remarks);
    }
    
    @PostMapping("/updateResult")
    @ApiOperation(value = "Update the result")
    public Result updateResult(String id, String result, String comment) {
        return applicationService.updateResult(id, result,comment);
    }
    
    @GetMapping("/getTotalCount")
    @ApiOperation(value = "Get the number of all applications")
    public Result getTotalCount() {
        return applicationService.getTotalCount();
    }
    
    @GetMapping("/getApplications")
    @ApiOperation(value = "Get all applications. " +
            "`limit` is the number of the results, ignoring the first `offset` records")
    public Result getApplications(int limit, int offset) {
        return applicationService.getApplications(limit, offset);
    }

}
