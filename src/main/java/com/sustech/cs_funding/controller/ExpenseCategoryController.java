package com.sustech.cs_funding.controller;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.service.expense_category.ExpenseCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@CrossOrigin
@Api(tags = "接口测试")
public class ExpenseCategoryController {
    @Autowired
    ExpenseCategoryService expenseCategoryService;

    @GetMapping("/getAllExpenseCategories")
    @ApiOperation(value = "Get All Expense Categories")
    public Result getAllResearchGroups() {
        return expenseCategoryService.getAllExpenseCategories();
    }
}