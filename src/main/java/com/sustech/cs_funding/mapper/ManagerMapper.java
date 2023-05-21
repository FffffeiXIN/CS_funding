package com.sustech.cs_funding.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ManagerMapper {
    @Insert("INSERT INTO group_fund (group_name, fund_name, total, used) VALUES (#{group_name}, #{fund_name}, #{total}, 0)")
    void allocateFundInfo(String group_name, String fund_name, Double total);
    
    @Update("UPDATE fund SET total_available = #{total} where code = #{code}")
    void allocateTotalFundInfo(String code, Double total);

    @Select("SELECT total_available FROM fund where code = #{code}")
    Double checkTotalFund(String code);

}
