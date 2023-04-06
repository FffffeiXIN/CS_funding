package com.sustech.cs_funding.mapper;

import com.sustech.cs_funding.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE name = #{username}")
    User getUserByName(String username);
    
    @Select("SELECT * FROM users WHERE sid = #{id}")
    User getUserById(int id);
    
    @Select("SELECT CASE WHEN password = #{password} THEN true ELSE false END FROM users WHERE sid = #{id}")
    Boolean login(int id, String password);
}
