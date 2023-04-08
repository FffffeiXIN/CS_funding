package com.sustech.cs_funding.controller;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.service.manager.ManagerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
@CrossOrigin
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @GetMapping("/moneyAllocation")
    @ApiOperation(value = "Manager to allocate the money")
    public Result moneyAllocation(String group_name, String fund_name, Double total) {
        return managerService.moneyAllocation(group_name, fund_name, total);
    }


}
