package com.sustech.cs_funding.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ApplicationMapper {
    @Insert("INSERT INTO application (fund_name, applicant_id, group_name, expense, expense_category, abstracts, remarks) " +
            "VALUES (#{fundName}, #{applicant_id}, #{group}, #{money}, #{category}, #{abstracts}, #{remarks})")
    void applyFunding(String fundName, Integer applicant_id, String group, Double money, Integer category,String abstracts, String remarks);
    
    @Update("UPDATE result=#{result}, comment=#{comment}  FROM application WHERE id=#{id}")
    void updateResult(String id, String result, String comment);
}
