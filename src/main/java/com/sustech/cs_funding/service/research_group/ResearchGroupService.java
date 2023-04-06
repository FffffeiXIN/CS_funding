package com.sustech.cs_funding.service.research_group;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.entity.ResearchGroup;
import com.sustech.cs_funding.mapper.ResearchGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ResearchGroupService {
    @Autowired
    ResearchGroupMapper researchGroupMapper;
    public Result getAllResearchGroups() {
        List<ResearchGroup> groups = researchGroupMapper.selectAllResearchGroup();
        return Result.ok().code(200).message("Success").addData("research_groups", groups);
    }

    public Result getFundingInfo(String funding, String group) {
        Integer total = researchGroupMapper.selectTotalFunding(group, funding);
        Integer used = researchGroupMapper.selectUsedFunding(group, funding);
        HashMap<String, Integer> res = new HashMap<>();
        res.put("total", total);
        res.put("used", used);
        res.put("rest", total - used);
        return Result.ok().code(200).message("Success").addData("funding_info", res);
    }
}
