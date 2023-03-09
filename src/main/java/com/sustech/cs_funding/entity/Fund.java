package com.sustech.cs_funding.entity;

import java.sql.Date;
import lombok.Data;

@Data

public class Fund {
    String name;
    String code;
    Date due_date;
    String execution_rate;
}
