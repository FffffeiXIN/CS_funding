package com.sustech.cs_funding.mapper;

import com.sustech.cs_funding.entity.Fund;
import com.sustech.cs_funding.entity.GroupFund;
import com.sustech.cs_funding.entity._ExpenditureSummary;
import com.sustech.cs_funding.entity._MultiUsedTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FundingMapper {

    @Select("SELECT * FROM group_fund WHERE group_name = #{group} and fund_name = #{funding}")
    GroupFund selectFunding(String group, String funding);
    
    @Select("SELECT * FROM group_fund WHERE group_name = #{group}")
    List<GroupFund> selectFundingByGroup(String group);
    
    @Select("SELECT * FROM group_fund WHERE fund_name = #{fund}")
    List<GroupFund> selectFundingBySum(String fund);
    
    @Select("SELECT name FROM fund")
    List<String> getAllFundingName();

    @Select("SELECT * FROM fund where name = #{name}")
    Fund getFundByName(String name);
    
    @Select("SELECT fund.code as code, fund.name as name, fund.due_date::date as due_date, SUM(group_fund.total) as total_sum, SUM(group_fund.used) as used_sum, (SUM(group_fund.total) - SUM(group_fund.used)) as left_sum, (100 * SUM(group_fund.used) / SUM(group_fund.total) || '%') as current_execution_rate, fund.execution_rate as qualified FROM group_fund JOIN fund ON fund.name = group_fund.fund_name group by fund.name")
    List<_MultiUsedTable> calculateFundingSum();
    
    @Select("SELECT group_name, fund_name, code, total, used, (total - used) as usable_left, (used / total || '%') as current_execution_rate, fund.execution_rate as qualified FROM group_fund JOIN fund ON  fund.name = group_fund.fund_name")
    List<_ExpenditureSummary> calculateExpenditureSummary();
}
