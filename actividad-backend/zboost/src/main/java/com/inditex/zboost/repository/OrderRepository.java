package com.inditex.zboost.repository;

import com.inditex.zboost.entity.Order;
import com.inditex.zboost.entity.OrderDetail;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The interface Order repository.
 */
public interface OrderRepository {
    
    List<Order> getOrders(int limit);
    
    List<Order> getOrdersBetweenDates(Date fromDate, Date toDate);
    
    OrderDetail getOrderDetail(long orderId);
    
}
