package br.com.vvaug.efoodusers.gateway.impl;

import br.com.vvaug.efoodusers.client.EfoodUsersDataServiceClient;
import br.com.vvaug.efoodusers.exception.ApplicationException;
import br.com.vvaug.efoodusers.gateway.EfoodUsersDataServiceGateway;
import br.com.vvaug.efoodusers.request.FindUserRequest;
import br.com.vvaug.efoodusers.request.RegisterNewUserRequest;
import br.com.vvaug.efoodusers.response.UserResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EfoodUsersDataServiceGatewayImpl implements EfoodUsersDataServiceGateway {

    private final EfoodUsersDataServiceClient efoodUsersDataServiceClient;

    @Override
    public UserResponse findUser(String username) {
        try {
            return efoodUsersDataServiceClient.findUser(FindUserRequest.builder()
                            .username(username)
                            .build());
        } catch (FeignException ex){
            throw applicationException(ex);
        }
    }

    @Override
    public void register(RegisterNewUserRequest request) {
        try {
            efoodUsersDataServiceClient.create(request);
            log.info("User registered successfully.");
        } catch (FeignException ex){
            throw applicationException(ex);
        }
    }

    private ApplicationException applicationException(FeignException ex) {
        Object serviceResponse = null;
        try {
            serviceResponse = new ObjectMapper().readValue(ex.contentUTF8(), Object.class);
        } catch (JsonProcessingException e) {
            log.error("Não foi possível realizar o parse do response do serviço. Response: {}", ex.contentUTF8());
        }
        throw new ApplicationException("Ocorreu um erro ao consultar o serviço", ex.status(), null, true, "efood-users-ds", serviceResponse);
    }
}
