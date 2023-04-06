package com.sustech.cs_funding.entity;
import lombok.Data;

@Data
public class User {
    Integer id;
    String name;
    String role;
    String password;
}
