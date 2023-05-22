package com.sustech.cs_funding.mapper;

import com.sustech.cs_funding.entity.Fund;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface ManagerMapper {
    @Insert("INSERT INTO group_fund (group_name, fund_name, total, used) VALUES (#{group_name}, #{fund_name}, #{total}, 0)")
    void allocateFundInfo(String group_name, String fund_name, Double total);
    
    @Update("UPDATE fund SET total_available = #{total} where code = #{code}")
    void allocateTotalFundInfo(String code, Double total);

    @Select("SELECT total_available FROM fund where code = #{code}")
    Double checkTotalFund(String code);

    @Select("SELECT * FROM fund")
    List<Fund> getFundsInfo();

    @Update("UPDATE fund SET total_used = total_used + #{used} where name = #{fund_name}")
    void updateFundUsed(Double used, String fund_name);
}
