package com.inditex.zboost.repository;

import com.inditex.zboost.entity.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;
import java.util.Map;

public abstract class BaseRepository<T> {
    
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public BaseRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    protected List<String> queryForList(String query, Map<String, Object> params) {
        return jdbcTemplate.queryForList(query, params, String.class);
    }
    
    protected <V extends T> List<V> query(String query, Map<String, Object> params, Class<V> parameterizedClass) {
        return jdbcTemplate.query(query, params, new BeanPropertyRowMapper<>(parameterizedClass));
    }
    
    protected <V extends T> V queryForObject(String query, Map<String, Object> params, Class<V> parameterizedClass) {
        return jdbcTemplate.queryForObject(query, params, new BeanPropertyRowMapper<>(parameterizedClass));
    }
}
