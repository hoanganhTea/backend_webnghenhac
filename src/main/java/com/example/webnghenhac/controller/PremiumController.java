package com.example.webnghenhac.controller;

import com.example.webnghenhac.dto.request.ApiResponse;
import com.example.webnghenhac.dto.request.PremiumCreationRequest;
import com.example.webnghenhac.dto.request.PremiumUpdateRequest;
import com.example.webnghenhac.entity.Premium;
import com.example.webnghenhac.service.PremiumService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // Thay đổi theo miền của bạn
@RestController
@RequestMapping("/premium")
public class PremiumController {
    @Autowired
    private PremiumService premiumService;

    @GetMapping
    public List<Premium> getAllPremiums() {
        return premiumService.findAll();
    }

    @GetMapping("/{id}")
    public Premium getPremiumById(@PathVariable("id") String id) {
        return premiumService.findById(id);
    }

    @PostMapping
    public ApiResponse<Premium> createPremium(@RequestBody @Valid PremiumCreationRequest request) {
        ApiResponse<Premium> apiResponse = new ApiResponse<>();
        apiResponse.setResult(premiumService.createPremium(request));
        return apiResponse;
    }

    @PutMapping("/{id}")
    public Premium updatePremium(@PathVariable("id") String id, @RequestBody PremiumUpdateRequest request) {
        return premiumService.updatePremium(id, request);
    }

    @DeleteMapping("/{id}")
    public String deletePremium(@PathVariable("id") String id) {
        premiumService.deletePremium(id);
        return "Premium has been deleted";
    }
}
