package com.sustech.cs_funding.mapper;

import com.sustech.cs_funding.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE name = #{username}")
    User getUserByName(String username);
    
    @Select("SELECT * FROM users WHERE sid = #{id}")
    User getUserById(int id);
    
    @Select("SELECT CASE WHEN password = #{password} THEN true ELSE false END FROM users WHERE sid = #{id}")
    Boolean login(int id, String password);

    @Select("SELECT * FROM users")
    List<User> getAllUsers();

    @Select("SELECT sid FROM user_group WHERE group_name = #{group}")
    List<Integer> getAllUserIDsByGroup(String group);

    @Update("UPDATE users SET status = 'blocked' WHERE sid = #{id}")
    Boolean blockUser(int id);
}
