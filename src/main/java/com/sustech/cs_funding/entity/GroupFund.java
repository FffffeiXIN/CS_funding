package com.sustech.cs_funding.entity;

import lombok.Data;

@Data
public class GroupFund {
    String group_name;
    String fund_name;
    Double total;
    Double used;
}
