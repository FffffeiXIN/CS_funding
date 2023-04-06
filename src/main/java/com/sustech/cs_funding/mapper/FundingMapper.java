package com.sustech.cs_funding.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FundingMapper {

    @Select("SELECT total FROM group_funding WHERE group_name = #{group} and funding_name = #{funding}")
    Integer selectTotalFunding(String group, String funding);

    @Select("SELECT used FROM group_funding WHERE group_name = #{group} and funding_name = #{funding}")
    Integer selectUsedFunding(String group, String funding);
    
    
}
