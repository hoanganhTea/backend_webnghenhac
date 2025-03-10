package com.example.webnghenhac.service;

import com.example.webnghenhac.dto.request.AuthenticationRequest;
import com.example.webnghenhac.dto.request.IntrospectRequest;
import com.example.webnghenhac.exeception.AppException;
import com.example.webnghenhac.exeception.ErrorCode;
import com.example.webnghenhac.repository.AuthenticationResponse;
import com.example.webnghenhac.repository.IntrospectResponse;
import com.example.webnghenhac.repository.UserRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j
@Service
public class AuthenticationService {
    @Autowired
    UserRepository userRepository;
//    public boolean authenticate(AuthenticationRequest request) {
//        var user = userRepository.findByUsername(request.getUsername())
//                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
//
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
//        return passwordEncoder.matches(request.getPassword(), user.getPassword());
//
//    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if(!authenticated)
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        String role = user.getRole(); // Lấy role từ user
        var token = generateToken(request.getUsername(), role);
        AuthenticationResponse response = new AuthenticationResponse();
        response.setToken(token);
        response.setAuthenticated(true);
        return response;


    }


    @NonFinal
//    @Value("${jwt.signerKey}")
//    protected  String SIGNED_KEY;
    protected static final String SIGNED_KEY="ccUvuE75/6RGipOLKptQTdo0cVUy9BHjN/uUJvJnDU86sKbo+bNfEvEZEsKzlp21";

    public  IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException {
        var token = request.getToken();
        JWSVerifier verifier = new MACVerifier(SIGNED_KEY.getBytes());
        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expityTime = signedJWT.getJWTClaimsSet().getExpirationTime();
        var verified = signedJWT.verify(verifier);
        IntrospectResponse introspectResponse = new IntrospectResponse();
        introspectResponse.setValid(verified && expityTime.after(new Date()));

        return  introspectResponse;
    }

    private String generateToken(String username, String role) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issuer("devteria.com")
                .issueTime(new Date())
                .expirationTime(new Date(Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()))
                .claim("role", role) // Thêm role vào JWT
                .build();

        SignedJWT signedJWT = new SignedJWT(header, jwtClaimsSet);

        try {
            signedJWT.sign(new MACSigner(SIGNED_KEY.getBytes())); // Ký token
            return signedJWT.serialize(); // Trả về JWT token
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }
}
