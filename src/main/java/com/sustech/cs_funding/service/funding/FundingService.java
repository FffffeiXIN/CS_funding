package com.sustech.cs_funding.service.funding;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.entity.GroupFund;
import com.sustech.cs_funding.entity.ResearchGroup;
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
        System.out.println(res);
        res.put("total", groupFund.getTotal());
        res.put("used", groupFund.getUsed());
        res.put("rest", groupFund.getTotal() - groupFund.getUsed());
        return Result.ok().code(200).message("Success").addData("funding_info", res);
    }

    public Result getFunding() {
        List<ResearchGroup> groups = researchGroupMapper.selectAllResearchGroup();
        List<String> fundingNames = fundingMapper.getAllFundingName();
        HashMap<String, HashMap<String, HashMap<String, Double>>> res = new HashMap<>();

        for (ResearchGroup group : groups) {
            String group_name = group.getName();
            HashMap<String, HashMap<String, Double>> maps = new HashMap<>();

            for (String fund_name : fundingNames) {
                GroupFund groupFund = fundingMapper.selectFunding(group_name, fund_name);
                HashMap<String, Double> ress = new HashMap<>();
                System.out.println(groupFund.getTotal());
                System.out.println(groupFund.getUsed());
                ress.put("total", groupFund.getTotal());
                ress.put("used", groupFund.getUsed());
                ress.put("rest", groupFund.getTotal() - groupFund.getUsed());
                ress.put("execute_rate", groupFund.getUsed()/groupFund.getTotal());
                //
                ress.put("qualify", 1.0);
                maps.put(fund_name, ress);
            }
            res.put(group_name, maps);
        }
        return Result.ok().code(200).message("Success").addData("funding_info", res);
    }
}
