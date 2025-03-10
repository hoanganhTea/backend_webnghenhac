package com.example.webnghenhac.dto.request;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class OrdersUpdateRequest {
    @NotNull
    private String userId;

    @NotNull
    private String premiumId;

    @NotNull
    private String paymentMethodId;

    private LocalDateTime endTime;

    private boolean status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPremiumId() {
        return premiumId;
    }

    public void setPremiumId(String premiumId) {
        this.premiumId = premiumId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
