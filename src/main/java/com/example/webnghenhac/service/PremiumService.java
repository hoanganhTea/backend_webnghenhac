package com.example.webnghenhac.service;

import com.example.webnghenhac.dto.request.PremiumCreationRequest;
import com.example.webnghenhac.dto.request.PremiumUpdateRequest;
import com.example.webnghenhac.entity.Premium;
import com.example.webnghenhac.exeception.AppException;
import com.example.webnghenhac.exeception.ErrorCode;
import com.example.webnghenhac.repository.PremiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremiumService {
    @Autowired
    private PremiumRepository premiumRepository;

    public List<Premium> findAll() {
        return premiumRepository.findAll();
    }

    public Premium findById(String id) {
        return premiumRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PREMIUM_NOT_FOUND));
    }

    public Premium createPremium(PremiumCreationRequest request) {
        Premium premium = new Premium();
        premium.setName(request.getName());
        premium.setDuration(request.getDuration());
        premium.setDescribe(request.getDescribe());
        premium.setPrice(request.getPrice());
        return premiumRepository.save(premium);
    }

    public Premium updatePremium(String id, PremiumUpdateRequest request) {
        Premium premium = findById(id);
        premium.setName(request.getName());
        premium.setDuration(request.getDuration());
        premium.setDescribe(request.getDescribe());
        premium.setPrice(request.getPrice());
        return premiumRepository.save(premium);
    }

    public void deletePremium(String id) {
        if (!premiumRepository.existsById(id)) {
            throw new AppException(ErrorCode.PREMIUM_NOT_FOUND);
        }
        premiumRepository.deleteById(id);
    }
}