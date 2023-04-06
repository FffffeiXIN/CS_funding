package com.sustech.cs_funding.controller;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.service.research_group.ResearchGroupService;
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
public class ResearchGroupController {
    @Autowired
    ResearchGroupService researchGroupService;
    
    @GetMapping("/getAllResearchGroups")
    @ApiOperation(value = "Get All Research Groups")
    public Result getAllResearchGroups() {
        return researchGroupService.getAllResearchGroups();
    }

}
