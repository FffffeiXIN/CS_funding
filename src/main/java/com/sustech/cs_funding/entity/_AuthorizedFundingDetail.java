package com.sustech.cs_funding.entity;

import lombok.Data;

@Data
public class _AuthorizedFundingDetail {
    String code;
    String name;
    String groups;
    Double total_sum;
    Double used_sum;
    String first_category;
    String second_category;
}

