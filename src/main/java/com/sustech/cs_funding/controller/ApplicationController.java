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
@Api(tags = "ApplicationController")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @PostMapping("/applyFunding")
    @ApiOperation(value = "Apply Funding")
    public Result applyFunding(Integer id, String fundName, String applicant, String group, Double money, String first_category, String second_category, String abstracts, String remarks, String status) {
        return applicationService.applyFunding(id, fundName, applicant, group, money, first_category, second_category, abstracts, remarks, status);
    }

    @PostMapping("/applyFundingDraft")
    @ApiOperation(value = "A Draft of Apply Funding")
    public Result applyFundingDraft(Integer id, String fundName, String applicant, String group, Double money, String first_category, String second_category, String abstracts, String remarks) {
        return applicationService.applyFundingDraft(id, fundName, applicant, group, money, first_category, second_category, abstracts, remarks);
    }

    @PostMapping("/approvalApplication")
    @ApiOperation(value = "Approval Application")
    public Result updateResult(Integer id, String result, String comment) {
        return applicationService.updateResult(id, result, comment);
    }

    @GetMapping("/getTotalCount")
    @ApiOperation(value = "Get the number of all applications")
    public Result getTotalCount(String status) {
        return applicationService.getTotalCount(status);
    }

    @GetMapping("/getApplications")
    @ApiOperation(value = "Get all applications. " +
            "`limit` is the number of the results, ignoring the first `offset` records")
    public Result getApplications(int limit, int offset, String status) {
        return applicationService.getApplications(limit, offset, status);
    }

    @GetMapping("/getApplicationsByGroup")
    @ApiOperation(value = "Get all applications submitted by a group. " +
            "`limit` is the number of the results, ignoring the first `offset` records.")
    public Result getApplicationsByGroup(String group, int limit, int offset, String status) {
        return applicationService.getApplicationsByGroup(group, limit, offset, status);
    }

    @GetMapping("/getApplicationCountByGroup")
    @ApiOperation(value = "Get the number of all applications that are submitted by a group")
    public Result getApplicationCountByGroup(String group, String status) {
        return applicationService.getApplicationCountByGroup(group, status);
    }

    @GetMapping("/deleteApplicationByID")
    @ApiOperation(value = "delete Application By ID")
    public Result deleteApplicationByID(Integer id) {
        return applicationService.deleteApplicationByID(id);
    }
}
