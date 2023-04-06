package com.sustech.cs_funding.mapper;

import com.sustech.cs_funding.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE name = #{username}")
    User getUser(String username);
}
