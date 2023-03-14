package com.inditex.zboost;

import com.inditex.zboost.entity.ReportSummary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Orders tests.
 */
@SpringBootTest(classes = ZboostApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
class ReportSummaryTests {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Test
    void givenSalesData_whenRequestingAReportSummary_thenDataShouldBeValid() {
        ReportSummary object = this.testRestTemplate.getForObject(getHostPort() + "/report-summary", ReportSummary.class);

        assertEquals(9, object.getTotalProducts());
        assertEquals(8, object.getTotalOrders());
        assertEquals(1028.76, object.getTotalSales());

        Map<String, Integer> totalProductsByCategory = object.getTotalProductsByCategory();
        assertEquals(1, totalProductsByCategory.get("Dresses"));
        assertEquals(2, totalProductsByCategory.get("Jackets"));
        assertEquals(3, totalProductsByCategory.get("Pants"));
        assertEquals(3, totalProductsByCategory.get("Sweaters"));
    }

    private String getHostPort() {
        return "http://localhost:" + this.port;
    }

}
