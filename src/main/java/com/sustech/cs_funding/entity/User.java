package com.sustech.cs_funding.entity;
import lombok.Data;

@Data
public class User {
    Integer sid;
    String name;
    String role;
    String password;
    String status;
    Boolean online;
    String email;
    String department;
    String avatar;
}
