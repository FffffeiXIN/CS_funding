package com.sustech.cs_funding.mapper;
import com.sustech.cs_funding.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrdersMapper {
    @Select("select * from orders")
    List<Orders> getAllOrders();
}
