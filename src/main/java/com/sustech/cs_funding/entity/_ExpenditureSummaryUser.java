package com.sustech.cs_funding.entity;
import lombok.Data;

@Data
public class _ExpenditureSummaryUser {
    String code;
    String fund_name;
    String due_date;
    Double total_sum;
    Double used_sum;
    Double left_sum;
    String current_execution_rate;
    String qualified;
    String days_left;
}
