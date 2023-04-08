package com.sustech.cs_funding.mapper;

import com.sustech.cs_funding.entity.GroupFund;
import com.sustech.cs_funding.entity._ExpenditureSummary;
import com.sustech.cs_funding.entity._ExpenditureSummaryUser;
import com.sustech.cs_funding.entity._MultiUsedTable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ManagerMapper {
    @Insert("INSERT INTO group_fund (group_name, fund_name, total, used) VALUES (#{group_name}, #{fund_name}, #{total}, 0)")
    void allocateFundInfo(String group_name, String fund_name, Double total);


}
