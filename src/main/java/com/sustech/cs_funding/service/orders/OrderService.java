package com.sustech.cs_funding.service.orders;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.entity.Orders;
import com.sustech.cs_funding.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrdersMapper ordersMapper;
    public Result getAllOrders() {
        List<Orders> orders = ordersMapper.getAllOrders();
        return Result.ok().code(200).message("查询成功").addData("orders", orders);
    }
}
