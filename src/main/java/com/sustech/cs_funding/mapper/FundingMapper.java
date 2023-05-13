package com.sustech.cs_funding.mapper;

import com.sustech.cs_funding.entity.*;
import com.sustech.cs_funding.entity.Fund;
import com.sustech.cs_funding.entity.GroupFund;
import com.sustech.cs_funding.entity._ExpenditureSummary;
import com.sustech.cs_funding.entity._ExpenditureSummaryUser;
import com.sustech.cs_funding.entity._MultiUsedTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface FundingMapper {

    @Select("SELECT * FROM group_fund WHERE group_name = #{group} and fund_name = #{funding}")
    GroupFund selectFunding(String group, String funding);
    
    @Select("SELECT * FROM group_fund WHERE group_name LIKE %#{group}%")
    List<GroupFund> selectFundingByGroup(String group);
    
    @Select("SELECT * FROM group_fund WHERE fund_name = #{fund}")
    List<GroupFund> selectFundingBySum(String fund);
    
    @Select("SELECT name FROM fund")
    List<String> getAllFundingName();

    @Select("SELECT * FROM fund where name = #{name}")
    Fund getFundByName(String name);
    
    @Select("SELECT fund.code as code, fund.name as name, fund.due_date::date as due_date, SUM(group_fund.total) as total_sum, SUM(group_fund.used) as used_sum, (SUM(group_fund.total) - SUM(group_fund.used)) as left_sum, (100 * SUM(group_fund.used) / SUM(group_fund.total) || '%') as current_execution_rate, fund.execution_rate as qualified FROM group_fund JOIN fund ON fund.name = group_fund.fund_name group by fund.name")
    List<_MultiUsedTable> calculateFundingSum();
    
    @Select("SELECT group_name, fund_name, code, total, used, (total - used) as usable_left, (100 * used / total || '%') as current_execution_rate, fund.execution_rate as qualified FROM group_fund JOIN fund ON  fund.name = group_fund.fund_name")
    List<_ExpenditureSummary> calculateExpenditureSummary();

    @Select("SELECT subquery3.*, expense_category.first as first_category,expense_category.second as second_category from (\n" +
            "SELECT subquery2.*, group_fund.total as total_sum from (\n" +
            "SELECT fund.code as code, subquery1.* from\n" +
            "(SELECT fund_name as name, group_name as groups, expense_category, SUM(expense) as used_sum  from application where result = 'pass' group by fund_name, group_name, expense_category) as subquery1\n" +
            "JOIN fund on fund.name = subquery1.name) as subquery2\n" +
            "JOIN group_fund on group_fund.fund_name = subquery2.name and group_fund.group_name = subquery2.groups) as subquery3\n" +
            "JOIN expense_category on expense_category.id = subquery3.expense_category")
    List<_AuthorizedFundingDetail> calculateAuthorizedFundingDetail();

    @Select("SELECT subquery3.*, expense_category.first as first_category,expense_category.second as second_category from (\n" +
            "SELECT subquery2.*, group_fund.total as total_sum from (\n" +
            "SELECT fund.code as code, subquery1.* from\n" +
            "(SELECT fund_name as name, group_name as groups, expense_category, SUM(expense) as used_sum  from application where result = 'pass' and group_name = #{group_name} group by fund_name, group_name, expense_category) as subquery1\n" +
            "JOIN fund on fund.name = subquery1.name) as subquery2\n" +
            "JOIN group_fund on group_fund.fund_name = subquery2.name and group_fund.group_name = subquery2.groups) as subquery3\n" +
            "JOIN expense_category on expense_category.id = subquery3.expense_category")
    List<_AuthorizedFundingDetail> calculateAuthorizedFundingDetailBtGroup(String group_name);


    @Select("SELECT fund.code as code, fund.name as name, fund.due_date::date as due_date, group_fund.total as total_sum, group_fund.used as used_sum, (group_fund.total - group_fund.used) as left_sum, (100 * group_fund.used / group_fund.total || '%') as current_execution_rate, fund.execution_rate as qualified FROM group_fund JOIN fund ON fund.name = group_fund.fund_name where group_fund.group_name = #{group}")
    List<_ExpenditureSummaryUser> calculateExpenditureSummaryUser(String group);

    @Update("UPDATE group_fund SET used = used + #{addUsed} WHERE group_name = #{group} and fund_name = #{funding}")
    void updateFunding(String group, String funding, Double addUsed);
}
