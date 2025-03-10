package com.example.webnghenhac.service;

import com.example.webnghenhac.dto.request.PaymentMethodCreationRequest;
import com.example.webnghenhac.dto.request.PaymentMethodUpdateRequest;
import com.example.webnghenhac.entity.PaymentMethod;
import com.example.webnghenhac.exeception.AppException;
import com.example.webnghenhac.exeception.ErrorCode;
import com.example.webnghenhac.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodService {
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    public List<PaymentMethod> findAll() {
        return paymentMethodRepository.findAll();
    }

    public PaymentMethod findById(String id) {
        return paymentMethodRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION));
    }

    public PaymentMethod createPaymentMethod(PaymentMethodCreationRequest request) {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setName(request.getName());
        paymentMethod.setImage(request.getImage());
        return paymentMethodRepository.save(paymentMethod);
    }

    public PaymentMethod updatePaymentMethod(String id, PaymentMethodUpdateRequest request) {
        PaymentMethod paymentMethod = findById(id);
        paymentMethod.setName(request.getName());
        paymentMethod.setImage(request.getImage());
        return paymentMethodRepository.save(paymentMethod);
    }

    public void deletePaymentMethod(String id) {
        if (!paymentMethodRepository.existsById(id)) {
            throw new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION);
        }
        paymentMethodRepository.deleteById(id);
    }
}