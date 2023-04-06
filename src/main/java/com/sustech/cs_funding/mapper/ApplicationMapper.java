package com.sustech.cs_funding.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplicationMapper {
    @Insert("INSERT INTO application (fund_name, applicant_id, group_name, expense, expense_category, abstracts, remarks) " +
            "VALUES (#{fundName}, #{identity}, #{group}, #{money}, #{category}, #{abstracts}, #{remarks})")
    void applyFunding(String fundName, Integer applicant_id, String group, String money, Integer category,String abstracts, String remarks);
}
