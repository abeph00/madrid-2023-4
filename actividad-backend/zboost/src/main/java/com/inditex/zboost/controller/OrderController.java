package com.inditex.zboost.controller;

import com.inditex.zboost.entity.Order;
import com.inditex.zboost.entity.OrderDetail;
import com.inditex.zboost.exception.InvalidParameterException;
import com.inditex.zboost.service.OrderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * TODO: EJERCICIO 2.a) Listar pedidos y parámetro limit.
     * 
     * Revisar en la carpeta api la especificación del endpoint de orders e implementar el método rest correspondiente, 
     * que a su vez llamará al servicio correspondiente para continuar con la lógica de la llamada.
     *
     * Como buena practica, es recomendable realizar las validaciones de los parametros de entrada de las peticiones 
     * en la capa externa de la arquitectura, por lo que este seria un buen lugar para validar lo que se comenta en
     * el enunciado del ejercicio ;)
     *
     * PISTA: Si el limit no es valido, puedes usar la excepcion InvalidParameterException para notificarlo.
     */

    @GetMapping("/orders/{orderId}")
    public OrderDetail getProductDetail(@PathVariable(name = "orderId", required = true) long orderId) {
        return orderService.findOrderDetail(orderId);
    }
}
