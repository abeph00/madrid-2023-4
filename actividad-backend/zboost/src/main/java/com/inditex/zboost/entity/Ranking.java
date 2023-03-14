package com.inditex.zboost.entity;

import java.io.Serializable;
import java.util.List;

public class Ranking implements Serializable {

    private RankingType type;
    private List<ProductRank> productRank;

    public RankingType getType() {
        return type;
    }

    public void setType(RankingType type) {
        this.type = type;
    }

    public List<ProductRank> getProductRank() {
        return productRank;
    }

    public void setProductRank(List<ProductRank> productRank) {
        this.productRank = productRank;
    }
}
