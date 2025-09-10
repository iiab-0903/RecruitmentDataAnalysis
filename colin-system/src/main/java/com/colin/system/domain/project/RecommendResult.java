package com.colin.system.domain.project;

import java.math.BigDecimal;

public class RecommendResult {
    private Integer userId;

    private Integer jobId;

    private BigDecimal recommendIndex;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public BigDecimal getRecommendIndex() {
        return recommendIndex;
    }

    public void setRecommendIndex(BigDecimal recommendIndex) {
        this.recommendIndex = recommendIndex;
    }
}
