package com.sustech.cs_funding.controller;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.service.funding.FundingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funding")
@CrossOrigin
@Api(tags = "FundingController")
public class FundingController {
    @Autowired
    FundingService fundingService;
    
    @GetMapping("/getFundingInfoByGroupAndFundingName")
    @ApiOperation(value = "Get Funding Info By Group And FundingName")
    public Result getFundingInfo(String funding, String group) {
        return fundingService.getFundingInfo(funding, group);
    }

    @GetMapping("/getAllFundingInfo")
    @ApiOperation(value = "Get All Funding Info")
    public Result getAllFundingInfo() {
        return fundingService.getFunding();
    }

    @GetMapping("/queryFundingInfo")
    @ApiOperation(value = "Query funding info by the name of the research group")
    public Result queryFundingInfo(String group) {
        return fundingService.queryFunding(group);
    }
    
    @GetMapping("/multiTotalTable")
    @ApiOperation(value = "Calculate Sum of total value and used value by funding type")
    public Result multiTotalTable() {
        return fundingService.getFundingBySum();
    }

    @GetMapping("/multiDetailTable")
    @ApiOperation(value = "Funding authorization details")
    public Result multiDetailTable() {
        return fundingService.getAuthorizedFundingDetail();
    }
    @GetMapping("/oneGroupMultiDetailTable")
    @ApiOperation(value = "Funding authorization details")
    public Result oneGroupMultiDetailTable(String group_name) {
        return fundingService.getAuthorizedFundingDetailByGroup(group_name);
    }

    @GetMapping("/calculateExpenditureSummary")
    @ApiOperation(value = "ExpenditureSummary Table")
    public Result calculateExpenditureSummary() {
        return fundingService.getExpenditureSummary();
    }
    
    @GetMapping("/calculateExpenditureSummaryUser")
    @ApiOperation(value = "ExpenditureSummary Table per User")
    public Result calculateExpenditureSummaryUser(String group) {
        return fundingService.getExpenditureSummaryUser(group);
    }
    
    @GetMapping("/updateExecutionRate")
    @ApiOperation(value = "Update the Execution rate")
    public Result updateExecutionRate(String code, String rate) {
        return fundingService.allocateExerate(code, rate);
    }

    @GetMapping("/updateTotalMoneyByExecutionRate")
    @ApiOperation(value = "update Total Money By Execution rate")
    public Result updateTotalMoneyByExecutionRate() {
        return fundingService.updateTotalMoneyByExecutionRate();
    }
}
