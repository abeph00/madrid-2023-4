package com.inditex.zboost.repository;

import com.inditex.zboost.entity.Product;
import com.inditex.zboost.entity.ProductOrderItem;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepositoryImpl extends BaseRepository<Product> implements ProductRepository {
    
    private final NamedParameterJdbcTemplate jdbcTemplate;
    
    public ProductRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate){
        super(jdbcTemplate);
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> getProductCategories() {
        /**
         * TODO: EJERCICIO 1.a) Recupera las distintas categorias de los productos disponibles.
         */
        String sql = """
                """;
        
        return this.queryForList(sql, Map.of());
    }

    @Override
    public List<Product> getProductsByCategories(final Optional<List<String>> categories) {
        /*
         * TODO: EJERCICIO 1.b) Recuperar productos por sus categorias. 
         * 
         * Si dicho filtro no esta presente, recupera TODOS los productos del catalogo.
         *
         * Recuerda que el filtrado de categorias debe ser CASE-INSENSITIVE: la busqueda debe devolver los mismos resultados
         * filtrando por 'dresses', 'Dresses' o 'dRessES', por ejemplo.
         *
         * Para realizar filtrados en la clausula WHERE, recuerda que no es buena practica hacer un append directo de los
         * valores, si no que debes hacer uso de PreparedStatements para prevenir inyecciones de SQL. Ejemplo:
         *
         * "WHERE name = " + person.getName() + " AND ..." ==> MAL
         * "WHERE name = :name AND ..." ==> BIEN
         *
         *  Pista: A la hora de filtrar, pasar los valores a mayúsculas o minúsculas. Ejemplo: Uso de la función SQL upper().
         */
        Map<String, Object> params = new HashMap<>();

        String sql = """
            """;
        
        return this.query(sql, params, Product.class);
    }

    @Override
    public List<ProductOrderItem> getProductOrderItemsFromOrder(final long orderId) {
        
        /*
         * TODO: EJERCICIO 2.b) Recupera los detalles de un pedido dado su ID
         */
        return List.of();
    }

    @Override
    public Map<String, Integer> getTotalProductsByCategory() {
        /*
         * TODO: EJERCICIO 3. Reporte sumarizado
         */

        String sql = """
                """;

        final Map<String, Integer> totalProductsByCategory = new HashMap<>();
        this.jdbcTemplate.query(sql, rs -> {
            totalProductsByCategory.put(rs.getString("category"), rs.getInt("count"));
        });
        return totalProductsByCategory;
    }
}
