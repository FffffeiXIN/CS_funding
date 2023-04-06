package com.sustech.cs_funding.mapper;

import com.sustech.cs_funding.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT name, sid, role FROM users WHERE name = #{username}")
    User getUserByName(String username);
    
    @Select("SELECT name, sid, role FROM users WHERE sid = #{id}")
    User getUserById(Integer id);

    @Select("SELECT name, sid, role FROM users")
    List<User> getAllUsers();

    @Select("SELECT sid FROM user_group WHERE group_name = #{group}")
    List<Integer> getAllUserIDsByGroup(String group);

    @Update("UPDATE users SET status = 'blocked' WHERE sid = #{id}")
    Boolean blockUser(int id);

    @Update("UPDATE users SET status = 'normal' WHERE sid = #{id}")
    Boolean unBlockUser(int id);
    
    @Select("SELECT CASE WHEN count(*) = 1 THEN true ELSE false END FROM users WHERE password = #{password} AND sid = #{id}")
    Boolean login(Integer id, String password);
    
    @Delete("DELETE FROM users WHERE sid = #{id}")
    void delete(Integer id);
}
