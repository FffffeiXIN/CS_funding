package com.sustech.cs_funding.mapper;

import com.sustech.cs_funding.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT name, sid, role, status, email FROM users WHERE name = #{username}")
    User getUserByName(String username);
    
    @Select("SELECT name, sid, role, status, email FROM users WHERE sid = #{id}")
    User getUserById(Integer id);

    @Select("SELECT name, sid, role, status, email FROM users")
    List<User> getAllUsers();

    @Select("SELECT sid FROM user_group WHERE group_name = #{group}")
    List<Integer> getAllUserIDsByGroup(String group);

    @Update("UPDATE users SET status = 'blocked' WHERE sid = #{id}")
    Boolean blockUser(int id);

    @Update("UPDATE users SET status = 'normal' WHERE sid = #{id}")
    Boolean unBlockUser(int id);
    
    @Select("SELECT name, sid, role, status, email FROM users WHERE password = #{password} AND sid = #{id}")
    List<User> login(Integer id, String password);

    @Select("SELECT group_name FROM user_group WHERE sid = #{id}")
    List<String> getGroup(Integer id);
    
    @Delete("DELETE FROM users WHERE sid = #{id}")
    void delete(Integer id);

    @Update("UPDATE users SET password = #{password} WHERE sid = #{id}")
    Boolean modifyPasswd(Integer id, String password);

    @Select("SELECT email FROM users WHERE role = '管理员' and department = #{department}")
    String getAdminEmail(String department);

    @Insert("INSERT INTO users (name, sid, password, role, status, department, email) VALUES (#{name}, #{sid}, #{password}, #{role}, 'blocked', 'CSE', #{email})")
    void register(String name, Integer sid, String password, String role, String email) throws DuplicateKeyException;
    
    @Insert("INSERT INTO user_group (sid, group_name) VALUES (#{userid}, #{group})")
    void insertGroup(int userid, String group);

    @Delete("DELETE FROM user_group WHERE sid = #{userid} and group_name = #{group}")
    void deleteGroup(int userid, String group);

    @Update("UPDATE users SET role = #{role} where sid = #{userid}")
    void updateRole(int userid, String role);

    @Update("UPDATE users SET email = #{email} where sid = #{userid}")
    void updateEmail(int userid, String email);
}
