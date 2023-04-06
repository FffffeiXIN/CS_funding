package com.sustech.cs_funding.service.funding;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.mapper.FundingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class FundingService {
    @Autowired
    FundingMapper fundingMapper;

    public Result getFundingInfo(String funding, String group) {
        Integer total = fundingMapper.selectTotalFunding(group, funding);
        Integer used = fundingMapper.selectUsedFunding(group, funding);
        HashMap<String, Integer> res = new HashMap<>();
        res.put("total", total);
        res.put("used", used);
        res.put("rest", total - used);
        return Result.ok().code(200).message("Success").addData("funding_info", res);
    }
}
