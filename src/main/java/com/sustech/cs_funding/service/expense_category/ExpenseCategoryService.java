package com.sustech.cs_funding.service.expense_category;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.entity.ExpenseCategory;
import com.sustech.cs_funding.mapper.ExpenseCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseCategoryService {
    @Autowired
    ExpenseCategoryMapper expenseCategoryMapper;
    
    public Result getAllExpenseCategories() {
        List<ExpenseCategory> categories = expenseCategoryMapper.getAllExpenseCategories();
        return Result.ok().code(200).message("Success").addData("expense_categories", categories);
    }


}
