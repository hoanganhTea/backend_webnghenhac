package com.example.webnghenhac.dto;
import java.time.LocalDateTime;
import com.example.webnghenhac.entity.Orders;
public class OrdersSimpleDTO {
    private int orderId;
    private LocalDateTime createdAt;
    private LocalDateTime endTime;
    private boolean status;
    private String userId;
    private String premiumId;
    private String paymentMethodId;

    public OrdersSimpleDTO(Orders order) {
        this.orderId = order.getOrderId();
        this.createdAt = order.getCreatedAt();
        this.endTime = order.getEndTime();
        this.status = order.isStatus();
        this.userId = order.getUser().getId();  // Lấy ID của User
        this.premiumId = order.getPremium().getId();  // Lấy ID của Premium
        this.paymentMethodId = order.getPaymentMethod().getId();  // Lấy ID của PaymentMethod
    }

    // Getter & Setter
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getPremiumId() { return premiumId; }
    public void setPremiumId(String premiumId) { this.premiumId = premiumId; }

    public String getPaymentMethodId() { return paymentMethodId; }
    public void setPaymentMethodId(String paymentMethodId) { this.paymentMethodId = paymentMethodId; }
}

