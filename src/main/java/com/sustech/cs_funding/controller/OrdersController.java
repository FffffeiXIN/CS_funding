package com.sustech.cs_funding.controller;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.service.orders.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/cs_funding")
@Api(tags = "接口测试")
public class OrdersController {
    @Autowired
    OrderService orderService;

    @GetMapping("/getOrders")
    @ApiOperation(value = "订单模块测试")
    public Result getStudentAssignment() {
        return orderService.getAllOrders();
    }
}
