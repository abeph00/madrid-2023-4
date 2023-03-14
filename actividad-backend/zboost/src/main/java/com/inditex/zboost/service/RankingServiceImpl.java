package com.inditex.zboost.service;

import com.inditex.zboost.entity.*;
import com.inditex.zboost.utils.Converters;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

import static com.inditex.zboost.utils.Converters.toProductRank;

@Service
public class RankingServiceImpl implements RankingService {
    private final OrderService orderService;

    public RankingServiceImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Ranking ranking(RankingType rankingType, Date fromDate, Date toDate) {
        /**
         * TODO: EJERCICIO 4. Implementacion del Ranking
         *
         * Hasta ahora hemos ido resolviendo los ejercicios principalmente lanzando consultas SQL contra nuestra base de
         * datos. Creemos que es hora de ver tus skills de programacion, asi que este ejercicio debe resolverse de forma
         * puramente programatica sin realizar ninguna consulta directa contra la BD ;)
         *
         * PISTAS:
         * 1- No crees métodos nuevos, el ejercicio puede resolverse utilizando únicamente el {@link OrderService} inyectado.
         * 2- Para ayudarte en el ejercicio, haz uso del método {@link OrderService#findOrdersBetweenDates(Date, Date)} ya 
         * implementado para recuperar aquellos pedidos realizados entre dos fechas.
         * 3- También puedes hacer uso del método {@link OrderService#findOrderDetail(long)} que has implementado para 
         * recuperar los detalles de un pedido.
         * 4- Puedes hacer uso de los métodos de utilidad {@link com.inditex.zboost.utils.Converters#toProductRank(Product)}
         * y {@link com.inditex.zboost.utils.Converters#toProduct(ProductOrderItem)} para mapear los campos basicos de 
         * un producto entre los tipos {@link Product} {@link ProductOrderItem} y {@link ProductRank}.
         * 5- Recuerda que {@link ProductOrderItem} es una extension de {@link Product}, el cual tiene implementado el 
         * metodo hashcode que puede resultarte muy util ;)
         *
         * BONUS TRACK: Se valorara positivamente la resolucion del ejercicio mediante el API de Streams de Java
         *
         * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/package-summary.html
         * https://www.baeldung.com/java-8-streams
         */
        return new Ranking();
    }

}
