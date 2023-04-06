package com.sustech.cs_funding.mapper;

import com.sustech.cs_funding.entity.ResearchGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ResearchGroupMapper {
    @Select("SELECT * FROM groups")
    List<ResearchGroup> selectAllResearchGroup();

}
