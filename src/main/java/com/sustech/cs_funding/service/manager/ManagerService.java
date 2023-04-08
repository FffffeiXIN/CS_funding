package com.sustech.cs_funding.service.manager;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.entity.GroupFund;
import com.sustech.cs_funding.entity._ExpenditureSummary;
import com.sustech.cs_funding.entity._ExpenditureSummaryUser;
import com.sustech.cs_funding.entity._MultiUsedTable;
import com.sustech.cs_funding.mapper.FundingMapper;
import com.sustech.cs_funding.mapper.ManagerMapper;
import com.sustech.cs_funding.mapper.ResearchGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ManagerService {
    @Autowired
    ManagerMapper managerMapper;

    public Result moneyAllocation(String group_name, String fund_name, Double total){
        managerMapper.allocateFundInfo(group_name, fund_name, total);
        return Result.ok().code(200).message("Success");
    }
}
