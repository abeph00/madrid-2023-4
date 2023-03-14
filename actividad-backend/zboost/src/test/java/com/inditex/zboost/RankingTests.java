package com.inditex.zboost;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.zboost.entity.ProductRank;
import com.inditex.zboost.entity.Ranking;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * The type Orders tests.
 */
@SpringBootTest(classes = ZboostApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
class RankingTests {

    private static ObjectMapper MAPPER = new ObjectMapper();

    private static Ranking RANKING_AMOUNT;
    private static Ranking RANKING_AMOUNT_TWO_DAYS;
    private static Ranking RANKING_UNITS;
    private static Ranking RANKING_ORDERS;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @BeforeAll
    static void setUp() throws IOException {
        RANKING_AMOUNT = MAPPER.readValue(RankingTests.class.getClassLoader().getResource("ranking_amount.json"), Ranking.class);
        RANKING_AMOUNT_TWO_DAYS = MAPPER.readValue(RankingTests.class.getClassLoader().getResource("ranking_amount_two_days.json"), Ranking.class);
        RANKING_UNITS = MAPPER.readValue(RankingTests.class.getClassLoader().getResource("ranking_units.json"), Ranking.class);
        RANKING_ORDERS = MAPPER.readValue(RankingTests.class.getClassLoader().getResource("ranking_orders.json"), Ranking.class);
    }

    @Test
    void givenProductsAndOrders_whenRequestingARankingBetweenDatesByAmountSold_thenResultsShouldBeReturned() {
        Ranking ranking = this.testRestTemplate
                .getForObject(getHostPort() + "/ranking?type=amount&fromDate=2023-01-01&toDate=2023-12-12", Ranking.class, Map.of());
        Ranking rankingTwoDays = this.testRestTemplate
                .getForObject(getHostPort() + "/ranking?type=amount&fromDate=2023-01-01&toDate=2023-01-02", Ranking.class, Map.of());

        verifyRanking(ranking, RANKING_AMOUNT);
        verifyRanking(rankingTwoDays, RANKING_AMOUNT_TWO_DAYS);
    }

    @Test
    void givenProductsAndOrders_whenRequestingARankingBetweenDatesByUnitsSold_thenResultsShouldBeReturned() {
        Ranking ranking = this.testRestTemplate
                .getForObject(getHostPort() + "/ranking?type=units&fromDate=2023-01-01&toDate=2023-12-12", Ranking.class, Map.of());

        verifyRanking(ranking, RANKING_UNITS);
    }

    @Test
    void givenProductsAndOrders_whenRequestingARankingBetweenDatesByMostOrdered_thenResultsShouldBeReturned() {
        Ranking ranking = this.testRestTemplate
                .getForObject(getHostPort() + "/ranking?type=orders&fromDate=2023-01-01&toDate=2023-12-12", Ranking.class, Map.of());

        verifyRanking(ranking, RANKING_ORDERS);
    }

    private static void verifyRanking(Ranking actualRanking, Ranking expectedRanking) {
        assertEquals(expectedRanking.getType(), actualRanking.getType());
        List<ProductRank> productRank = actualRanking.getProductRank();
        assertEquals(expectedRanking.getProductRank().size(), productRank.size());
        for (int i = 0; i < productRank.size(); i++) {
            assertEquals(expectedRanking.getProductRank().get(i), productRank.get(i));
        }
    }


    private String getHostPort() {
        return "http://localhost:" + this.port;
    }

}
