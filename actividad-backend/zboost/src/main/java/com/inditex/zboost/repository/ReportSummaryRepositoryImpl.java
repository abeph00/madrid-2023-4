package com.inditex.zboost.repository;

import com.inditex.zboost.entity.ReportSummary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ReportSummaryRepositoryImpl extends BaseRepository<ReportSummary> implements ReportSummaryRepository {

    public ReportSummaryRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public ReportSummary getReportSummary() {
        /*
         * TODO: EJERCICIO 3. Reporte sumarizado
         */
        return new ReportSummary();
    }
}
