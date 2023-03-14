package com.inditex.zboost.service;

import com.inditex.zboost.entity.Order;
import com.inditex.zboost.entity.OrderDetail;

import java.util.Date;
import java.util.List;

public interface OrderService {

    List<Order> findOrders(int limit);

    List<Order> findOrdersBetweenDates(Date fromDate, Date toDate);

    OrderDetail findOrderDetail(long orderId);

}
