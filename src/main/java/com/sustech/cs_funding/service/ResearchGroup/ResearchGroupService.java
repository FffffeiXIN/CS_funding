package com.sustech.cs_funding.service.ResearchGroup;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.entity.ResearchGroup;
import com.sustech.cs_funding.mapper.ResearchGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearchGroupService {
    @Autowired
    ResearchGroupMapper researchGroupMapper;
    public Result getAllResearchGroups() {
        List<ResearchGroup> groups = researchGroupMapper.selectAllResearchGroup();
        return Result.ok().code(200).message("Success").addData("researchGroups", groups);
    }
}
