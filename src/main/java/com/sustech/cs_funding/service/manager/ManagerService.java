package com.sustech.cs_funding.service.manager;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    ManagerMapper managerMapper;

    public Result moneyAllocation(String group_name, String fund_name, Double total){
        managerMapper.allocateFundInfo(group_name, fund_name, total);
        return Result.ok().code(200).message("Success");
    }
    
    public Result totalmoneyAllocation(String code, Double total){
        managerMapper.allocateTotalFundInfo(code, total);
        return Result.ok().code(200).message("Success");
    }

    public Result totalmoneyCheck(String code){
        Double totalmoney = managerMapper.checkTotalFund(code);
        return  Result.ok().code(200).message("Success").addData("total_money", totalmoney);
    }
}
