package com.example.webnghenhac.controller;

import com.example.webnghenhac.dto.request.PaymentMethodCreationRequest;
import com.example.webnghenhac.dto.request.PaymentMethodUpdateRequest;
import com.example.webnghenhac.entity.PaymentMethod;
import com.example.webnghenhac.service.PaymentMethodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/payment-methods")
public class PaymentMethodController {
    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping
    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodService.findAll();
    }

    @GetMapping("/{id}")
    public PaymentMethod getPaymentMethodById(@PathVariable("id") String id) {
        return paymentMethodService.findById(id);
    }

    @PostMapping
    public PaymentMethod createPaymentMethod(@RequestBody @Valid PaymentMethodCreationRequest request) {
        return paymentMethodService.createPaymentMethod(request);
    }

    @PutMapping("/{id}")
    public PaymentMethod updatePaymentMethod(@PathVariable("id") String id, @RequestBody @Valid PaymentMethodUpdateRequest request) {
        return paymentMethodService.updatePaymentMethod(id, request);
    }

    @DeleteMapping("/{id}")
    public String deletePaymentMethod(@PathVariable("id") String id) {
        paymentMethodService.deletePaymentMethod(id);
        return "Payment Method has been deleted";
    }
}
