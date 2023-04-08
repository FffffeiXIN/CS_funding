package com.sustech.cs_funding.entity;
import lombok.Data;

@Data
public class _ExpenditureSummary {
    String code;
    String fund_name;
    String group_name;
    Double used;
    Double total;
    Double usable_left;
    String current_execution_rate;
    String qualified;
}
