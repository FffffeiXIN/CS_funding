package com.sustech.cs_funding.mapper;

import com.sustech.cs_funding.entity.GroupFund;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FundingMapper {

    @Select("SELECT total FROM group_fund WHERE group_name = #{group} and fund_name = #{funding}")
    Integer selectTotalFunding(String group, String funding);

    @Select("SELECT used FROM group_fund WHERE group_name = #{group} and fund_name = #{funding}")
    Integer selectUsedFunding(String group, String funding);
    
    @Select("SELECT * FROM group_fund WHERE group_name = #{group}")
    List<GroupFund> selectFundingByGroup(String group);
    
    @Select("SELECT * FROM group_fund WHERE fund_name = #{fund}")
    List<GroupFund> selectFundingBySum(String fund);
    
    @Select("SELECT name FROM fund")
    List<String> getAllFundingName();
}
