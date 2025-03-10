package com.example.webnghenhac.service;

import com.example.webnghenhac.dto.request.OrdersCreationRequest;
import com.example.webnghenhac.dto.request.OrdersUpdateRequest;
import com.example.webnghenhac.entity.Orders;
import com.example.webnghenhac.entity.Premium;
import com.example.webnghenhac.entity.PaymentMethod;
import com.example.webnghenhac.entity.User;
import com.example.webnghenhac.repository.OrdersRepository;
import com.example.webnghenhac.repository.PremiumRepository;
import com.example.webnghenhac.repository.PaymentMethodRepository;
import com.example.webnghenhac.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PremiumRepository premiumRepository;
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Orders getOrderById(int id) {
        return ordersRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Orders createOrder(OrdersCreationRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Premium premium = premiumRepository.findById(request.getPremiumId())
                .orElseThrow(() -> new RuntimeException("Premium not found"));
        PaymentMethod paymentMethod = paymentMethodRepository.findById(request.getPaymentMethodId())
                .orElseThrow(() -> new RuntimeException("Payment method not found"));

        Orders order = new Orders();
        order.setUser(user);
        order.setPremium(premium);
        order.setPaymentMethod(paymentMethod);

        LocalDateTime createdAt = LocalDateTime.now();
        order.setCreatedAt(createdAt);

        // Cộng thêm số ngày từ duration của Premium
        order.setEndTime(createdAt.plusDays(premium.getDuration()));

        order.setStatus(false);

        return ordersRepository.save(order);
    }

    public Orders updateOrder(int id, OrdersUpdateRequest request) {
        Orders existingOrder = getOrderById(id);
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Premium premium = premiumRepository.findById(request.getPremiumId()).orElseThrow(() -> new RuntimeException("Premium not found"));
        PaymentMethod paymentMethod = paymentMethodRepository.findById(request.getPaymentMethodId()).orElseThrow(() -> new RuntimeException("Payment method not found"));

        existingOrder.setUser(user);
        existingOrder.setPremium(premium);
        existingOrder.setPaymentMethod(paymentMethod);
        existingOrder.setEndTime(request.getEndTime());
        existingOrder.setStatus(request.isStatus());

        return ordersRepository.save(existingOrder);
    }

    public void deleteOrder(int id) {
        ordersRepository.deleteById(id);
    }
}
