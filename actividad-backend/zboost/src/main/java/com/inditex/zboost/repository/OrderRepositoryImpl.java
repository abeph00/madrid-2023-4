package com.inditex.zboost.repository;

import com.inditex.zboost.entity.Order;
import com.inditex.zboost.entity.OrderDetail;
import com.inditex.zboost.exception.NotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepositoryImpl extends BaseRepository<Order> implements OrderRepository {
    
    public OrderRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public List<Order> getOrders(int limit) {
        /*
         * TODO: EJERCICIO 2.a) Recupera un listado de los ultimos N pedidos (recuerda ordenar por fecha)
         */
        return List.of();
    }

    @Override
    public List<Order> getOrdersBetweenDates(Date fromDate, Date toDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("startDate", new java.sql.Date(fromDate.getTime()));
        params.put("toDate", new java.sql.Date(toDate.getTime()));
        String sql = """
                SELECT id, date, status
                FROM Orders
                WHERE date BETWEEN :startDate AND :toDate
                """;
        
        return this.query(sql, params, Order.class);
    }

    @Override
    public OrderDetail getOrderDetail(long orderId) {
        /*
         * TODO: EJERCICIO 2.b) Recupera los detalles de un pedido dado su ID
         * 
         * Recuerda que, si un pedido no es encontrado por su ID, debes notificarlo debidamente como se recoge en el contrato
         * que estas implementando (codigo de estado HTTP 404 Not Found). Para ello puedes usar la excepcion {@link com.inditex.zboost.exception.NotFoundException}
         */
        return new OrderDetail();
    }
}
