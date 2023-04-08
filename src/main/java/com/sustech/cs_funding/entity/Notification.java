package com.sustech.cs_funding.entity;

import lombok.Data;

@Data
public class Notification {
    Integer id;
    Integer user_id;
    String messages;
    String date;
}
