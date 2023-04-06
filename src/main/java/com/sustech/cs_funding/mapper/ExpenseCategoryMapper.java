package com.sustech.cs_funding.mapper;

import com.sustech.cs_funding.entity.ExpenseCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExpenseCategoryMapper {
    @Select("SELECT * FROM expense_category")
    List<ExpenseCategory> getAllExpenseCategories();
}
