package com.sustech.cs_funding.mapper;

import com.sustech.cs_funding.entity.ResearchGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResearchGroupMapper {
    List<ResearchGroup> selectAllResearchGroup();
}
