package com.sustech.cs_funding.service.funding;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.entity.*;
import com.sustech.cs_funding.entity._MultiUsedTable;
import com.sustech.cs_funding.mapper.FundingMapper;
import com.sustech.cs_funding.mapper.ResearchGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class FundingService {
    @Autowired
    FundingMapper fundingMapper;

    @Autowired
    ResearchGroupMapper researchGroupMapper;

    public Result getFundingInfo(String funding, String group) {
        GroupFund groupFund = fundingMapper.selectFunding(group, funding);
        HashMap<String, Double> res = new HashMap<>();
//        System.out.println(res);
        res.put("total", groupFund.getTotal());
        res.put("used", groupFund.getUsed());
        res.put("rest", groupFund.getTotal() - groupFund.getUsed());
        return Result.ok().code(200).message("Success").addData("funding_info", res);
    }

    public Result getFunding() {
        List<ResearchGroup> groups = researchGroupMapper.selectAllResearchGroup();
        List<String> fundingNames = fundingMapper.getAllFundingName();
        ArrayList<HashMap<String, Object>> whole_res = new ArrayList<>();


        for (ResearchGroup group : groups) {
            HashMap<String, Object> res = new HashMap<>();
            String group_name = group.getName();
            ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();

            for (String fund_name : fundingNames) {
                GroupFund groupFund = fundingMapper.selectFunding(group_name, fund_name);
                HashMap<String, Object> ress = new HashMap<>();
                System.out.println(groupFund.getTotal());
                System.out.println(groupFund.getUsed());
                ress.put("value", groupFund.getTotal());
                ress.put("used", groupFund.getUsed());
                ress.put("rest", groupFund.getTotal() - groupFund.getUsed());
                ress.put("execute_rate", groupFund.getUsed()/groupFund.getTotal());
                //Todo:达标率未处理
                ress.put("qualify", 1.0);
                ress.put("name", fund_name);
                arrayList.add(ress);
            }

            res.put("group_name", group_name);
            res.put("fundings", arrayList);
            whole_res.add(res);
        }
        return Result.ok().code(200).message("Success").addData("funding_info", whole_res);
    }
    
    public Result getFundingBySum(){
        List<_MultiUsedTable> multiusedtable = fundingMapper.calculateFundingSum();
        return  Result.ok().code(200).message("Success").addData("funding_info", multiusedtable);
    }
    public Result getAuthorizedFundingDetail(){
        List<_AuthorizedFundingDetail> authorizedFundingDetails = fundingMapper.calculateAuthorizedFundingDetail();
        return  Result.ok().code(200).message("Success").addData("funding_info", authorizedFundingDetails);
    }

    public Result getExpenditureSummary(){
        List<_ExpenditureSummary> expenditureSumMap = fundingMapper.calculateExpenditureSummary();
        return  Result.ok().code(200).message("Success").addData("funding_info", expenditureSumMap);
    }
}
