package com.sustech.cs_funding.controller;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.service.funding.FundingService;
import com.sustech.cs_funding.service.research_group.ResearchGroupService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funding")
@CrossOrigin
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
}