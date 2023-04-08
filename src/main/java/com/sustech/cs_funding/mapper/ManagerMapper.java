package com.sustech.cs_funding.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ManagerMapper {
    @Insert("INSERT INTO group_fund (group_name, fund_name, total, used) VALUES (#{group_name}, #{fund_name}, #{total}, 0)")
    void allocateFundInfo(String group_name, String fund_name, Double total);


}
