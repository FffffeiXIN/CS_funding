package com.sustech.cs_funding.mapper;

import com.sustech.cs_funding.entity.Application;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApplicationMapper {
    @Insert("INSERT INTO application (fund_name, applicant_id, group_name, expense, expense_category, abstracts, remarks, result) " +
            "VALUES (#{fundName}, #{applicant_id}, #{group}, #{money}, #{category}, #{abstracts}, #{remarks}, 'pending')")
    void insertApp(String fundName, Integer applicant_id, String group, Double money, Integer category,String abstracts, String remarks);

    @Insert("INSERT INTO application (fund_name, applicant_id, group_name, expense, expense_category, abstracts, remarks, result) " +
            "VALUES (#{fundName}, #{applicant_id}, #{group}, #{money}, #{category}, #{abstracts}, #{remarks}, 'draft')")
    void insertAppDraft(String fundName, Integer applicant_id, String group, Double money, Integer category,String abstracts, String remarks);

    @Update("UPDATE application set fund_name=#{fundName}, expense=#{money}, expense_category=#{category}, abstracts=#{abstracts}, remarks=#{remarks}, result = 'pending', comment = null WHERE id=#{id}")
    void updateApp(Integer id, String fundName, Double money, Integer category,String abstracts, String remarks);

    @Update("UPDATE application set result=#{result}, comment=#{comment} WHERE id=#{id}")
    void updateResult(Integer id, String result, String comment);

    @Select("SELECT count(*) FROM application WHERE result LIKE #{status}")
    int getTotalCount(String status);
    
    @Select("SELECT * FROM application WHERE result LIKE #{status} ORDER BY id LIMIT #{limit} OFFSET #{offset}")
    List<Application> getApplications(int limit, int offset, String status);
    
    @Select("SELECT * FROM application WHERE id=#{id}")
    Application getApplicationById(Integer id);

    @Select("SELECT * FROM application WHERE result LIKE #{status} AND group_name = #{group} ORDER BY id LIMIT #{limit} OFFSET #{offset}")
    List<Application> getApplicationsByGroup(String group, int limit, int offset, String status);

    @Select("SELECT count(*) FROM application WHERE group_name = #{group} AND result LIKE #{status}")
    Integer getApplicationCountByGroup(String group, String status);

    @Delete("DELETE FROM application WHERE id=#{id}")
    void deleteApplicationById(Integer id);
}
