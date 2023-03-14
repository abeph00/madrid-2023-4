package com.inditex.zboost.entity;

import java.io.Serializable;

public class ProductRank extends Product implements Serializable {

    private Integer rank;
    private Double score;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductRank that = (ProductRank) o;
        return rank.equals(that.rank) && score.equals(that.score);
    }
}
