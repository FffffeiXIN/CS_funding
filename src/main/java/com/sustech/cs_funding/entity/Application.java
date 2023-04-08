package com.sustech.cs_funding.entity;
import lombok.Data;

@Data
public class Application {
    String fund_name;
    Integer applicant_id;
    String group_name;
    Double expense;
    Integer expense_category;
    String abstracts;
    String result;
    String remarks;
    String comment;
    Integer id;
}
