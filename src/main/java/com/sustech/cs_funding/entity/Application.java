package com.sustech.cs_funding.entity;
import lombok.Data;

@Data
public class Application {
    String fund_name;
    Integer applicant_id;
    String group_name;
    Integer expense;
    String expense_category;
    String summary;
    String note;
    Integer id;
}
