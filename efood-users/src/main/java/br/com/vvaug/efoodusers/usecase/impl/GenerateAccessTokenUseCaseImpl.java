package br.com.vvaug.efoodusers.usecase.impl;

import br.com.vvaug.efoodusers.exception.ApplicationException;
import br.com.vvaug.efoodusers.response.JwtTokenResponse;
import br.com.vvaug.efoodusers.security.dto.User;
import br.com.vvaug.efoodusers.usecase.GenerateAccessTokenUseCase;
import br.com.vvaug.efoodusers.usecase.GenerateJsonWebEncryptionPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenerateAccessTokenUseCaseImpl implements GenerateAccessTokenUseCase {

    private final ObjectMapper objectMapper;
    private final GenerateJsonWebEncryptionPayload generateJsonWebEncryptionPayload;

    @Value("${app.config.security.jwt-secret}")
    private String secret;
    @Value("${app.name}")
    private String applicationName;

    @Override
    public JwtTokenResponse execute(Authentication authentication) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, 10);
        Date expiration = now.getTime();
        var jws = Jwts.builder()
                .claim("authData", generateJsonWebEncryptionPayload.execute((User) authentication.getPrincipal()))
                .setIssuer(applicationName)
                .setExpiration(expiration)
                .setSubject("efood")
                .signWith(getKey())
                .compact();
        return JwtTokenResponse.builder()
                .jwt(jws)
                .build();
    }



    private Key getKey(){
        byte[] keyBytes = this.secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
