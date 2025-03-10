package com.example.webnghenhac.controller;

import com.example.webnghenhac.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Random;
import com.example.webnghenhac.dto.request.EmailRequest;
import com.example.webnghenhac.repository.OtpResponse;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "http://127.0.0.1:5500") // Chỉ cho phép frontend gọi API
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-otp")
    public OtpResponse sendOtp(@RequestBody EmailRequest request) {
        String otp = generateOtp(); // Tạo OTP ngẫu nhiên
        String subject = "Xác thực đăng ký";
        String message = "Mã OTP của bạn là: " + otp;

        emailService.sendEmail(request.getEmail(), subject, message);
        return new OtpResponse(otp); // Gửi OTP về frontend để kiểm tra
    }

    // Hàm tạo OTP ngẫu nhiên (4 ký tự)
    private String generateOtp() {
        Random random = new Random();
        int otp = 1000 + random.nextInt(9000); // Tạo số ngẫu nhiên từ 1000 đến 9999
        return String.valueOf(otp);
    }
}