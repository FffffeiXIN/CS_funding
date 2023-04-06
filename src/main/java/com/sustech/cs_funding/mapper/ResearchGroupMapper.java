package com.sustech.cs_funding.mapper;

import com.sustech.cs_funding.entity.ResearchGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ResearchGroupMapper {
    @Select("SELECT * FROM groups")
    List<ResearchGroup> selectAllResearchGroup();

    @Select("SELECT total FROM group_funding WHERE group_name = #{group} and funding_name = #{funding}")
    Integer selectTotalFunding(String group, String funding);

    @Select("SELECT used FROM group_funding WHERE group_name = #{group} and funding_name = #{funding}")
    Integer selectUsedFunding(String group, String funding);



}
