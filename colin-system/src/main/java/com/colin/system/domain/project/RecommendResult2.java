package com.colin.system.domain.project;

import java.math.BigDecimal;

public class RecommendResult2 {
    private Integer userId;

    private Integer showId;

    private BigDecimal recommendIndex;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public BigDecimal getRecommendIndex() {
        return recommendIndex;
    }

    public void setRecommendIndex(BigDecimal recommendIndex) {
        this.recommendIndex = recommendIndex;
    }
}
