package com.example.webnghenhac.controller;

import com.example.webnghenhac.dto.request.ApiResponse;
import com.example.webnghenhac.dto.request.AuthenticationRequest;
import com.example.webnghenhac.dto.request.IntrospectRequest;
import com.example.webnghenhac.repository.AuthenticationResponse;
import com.example.webnghenhac.repository.IntrospectResponse;
import com.example.webnghenhac.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
@CrossOrigin(origins = "*") // Thay đổi theo miền của bạn
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse authenticate(@RequestBody AuthenticationRequest request) {
        AuthenticationResponse result = authenticationService.authenticate(request);
       ApiResponse apiResponse = new ApiResponse();
       apiResponse.setResult(result);
       return apiResponse;
    }

    @PostMapping("/introspect")
    ApiResponse authenticate(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        IntrospectResponse result = authenticationService.introspect(request);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResult(result);
        return apiResponse;
    }

}
