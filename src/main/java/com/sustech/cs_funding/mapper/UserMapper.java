package com.sustech.cs_funding.mapper;

import com.sustech.cs_funding.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE name = #{username}")
    User getUserByName(String username);
    
    @Select("SELECT * FROM users WHERE sid = #{id}")
    User getUserById(Integer id);

    @Select("SELECT name, sid, role FROM users")
    List<User> getAllUsers();
    
    @Select("SELECT CASE WHEN count(*) = 1 THEN true ELSE false END FROM users WHERE password = #{password} AND sid = #{id}")
    Boolean login(Integer id, String password);
    
    @Delete("DELETE FROM users WHERE sid = #{id}")
    void delete(Integer id);
}
