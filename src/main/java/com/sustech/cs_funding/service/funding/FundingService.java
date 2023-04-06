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
        Integer total = fundingMapper.selectTotalFunding(group, funding);
        Integer used = fundingMapper.selectUsedFunding(group, funding);
        HashMap<String, Integer> res = new HashMap<>();
        res.put("total", total);
        res.put("used", used);
        res.put("rest", total - used);
        return Result.ok().code(200).message("Success").addData("funding_info", res);
    }
    
    public Result getFundingByGroup(){
        List<ResearchGroup> groups = researchGroupMapper.selectAllResearchGroup();
        List<String> fundingNames = fundingMapper.getAllFundingName();
        HashMap<String, HashSet<String, HashMap<String, Double>>> res = new HashMap<>();
        
        for (int i = 0; i < groups.size(); i++) {
            String group_name = groups.get(i).getName();
            res.put(group_name,new ArrayList<>());
            
            for (int j = 0; j < fundingNames.size(); j++) {
                String fund_name = fundingNames.get(j);
                HashMap<String, Double> maps = new HashMap<>();
                maps.put("total", groupFunds.);
            }
            List<GroupFund> groupFunds= fundingMapper.selectFundingByGroup(group_name);
            
            
        }
    }
    
    public Result getFundingBySum(){
        
    }
}
