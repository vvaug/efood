package br.com.vvaug.efoodusers.usecase.impl;

import br.com.vvaug.efoodusers.exception.ApplicationException;
import br.com.vvaug.efoodusers.security.dto.User;
import br.com.vvaug.efoodusers.usecase.GenerateJsonWebEncryptionPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.keys.AesKey;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
@RequiredArgsConstructor
public class GenerateJsonWebEncryptionPayloadImpl implements GenerateJsonWebEncryptionPayload {

    private final ObjectMapper objectMapper;
    @Value("${app.config.security.jwe-secret}")
    private String secret;

    @Override
    public String execute(User user) {
        JsonWebEncryption jwe = new JsonWebEncryption();
        jwe.setPayload("Hello World!");
        jwe.setAlgorithmHeaderValue(KeyManagementAlgorithmIdentifiers.A128KW);
        jwe.setEncryptionMethodHeaderParameter(ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256);
        jwe.setKey(getKey());
        return getSerializedJwe(jwe);
    }

    public static String getSerializedJwe(JsonWebEncryption jwe){
        try {
            return jwe.getCompactSerialization();
        } catch (JoseException e) {
            throw new ApplicationException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
    public String getUserPayload(User user){
        try {
            return this.objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException ex){
            throw new ApplicationException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    public Key getKey(){
        return new AesKey(this.secret.getBytes());
    }
}
