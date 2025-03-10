package com.example.webnghenhac.dto.request;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class OrdersCreationRequest {
    @NotNull
    private String userId;

    @NotNull
    private String premiumId;

    @NotNull
    private String paymentMethodId;


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


}
