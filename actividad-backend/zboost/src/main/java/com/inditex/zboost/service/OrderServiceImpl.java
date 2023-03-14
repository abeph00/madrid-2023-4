package com.inditex.zboost.service;

import com.inditex.zboost.entity.Order;
import com.inditex.zboost.entity.OrderDetail;
import com.inditex.zboost.entity.ProductOrderItem;
import com.inditex.zboost.exception.NotFoundException;
import com.inditex.zboost.repository.OrderRepository;
import com.inditex.zboost.repository.ProductRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Order> findOrders(int limit) {
        return orderRepository.getOrders(limit);
    }

    @Override
    public List<Order> findOrdersBetweenDates(Date fromDate, Date toDate) {
        return this.orderRepository.getOrdersBetweenDates(fromDate, toDate);
    }

    @Override
    public OrderDetail findOrderDetail(long orderId) {
        /**
         * TODO: EJERCICIO 2.b) Recupera los detalles de un pedido dado su ID
         * 
         * Revisar métodos {@link orderRepository#getOrderDetail(orderId)} y {@link productRepository#getProductOrderItemsFromOrder(orderId)}
         *
         * TODO: EJERCICIO 2.c) Añadir caché al método findOrderDetail.
         * 
         * Añadir una spring caché de tipo "simple". Para hacerlo, sigue la documentación de spring boot caché: 
         * https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#io.caching
         */

        // Invoca al repositorio para recuperar el detalle de un pedido
        OrderDetail orderDetail = new OrderDetail();

        // Una vez has conseguido recuperar los detalles del pedido, faltaria recuperar los productos que forman parte de el...
        List<ProductOrderItem> products = List.of();
        
        orderDetail.setProducts(products);
        return orderDetail;
    }
}
