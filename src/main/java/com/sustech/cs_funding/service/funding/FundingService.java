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
        HashMap<String, HashMap<String,String>> res = new HashMap<>();

        for (ResearchGroup group : groups) {
            String group_name = group.getName();
            HashMap<String,String> maps = new HashMap<>();

            for (String fund_name : fundingNames) {
                GroupFund groupFund = fundingMapper.selectFunding(group_name, fund_name);

//                System.out.println(groupFund.getTotal());
//                System.out.println(groupFund.getUsed());
                maps.put("funding_name", fund_name);
                maps.put("total", groupFund.getTotal().toString());
                maps.put("used", groupFund.getUsed().toString());
                Double rest = groupFund.getTotal() - groupFund.getUsed();
                maps.put("rest", rest.toString());
                Double ratio = groupFund.getUsed()/groupFund.getTotal();
                maps.put("execute_rate", ratio.toString());
                //
                maps.put("qualify", "50%");
            }
            res.put(group_name, maps);
        }
        return Result.ok().code(200).message("Success").addData("funding_info", res);
    }
}
