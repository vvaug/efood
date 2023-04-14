package br.com.vvaug.efoodregister.gateway.impl;

import br.com.vvaug.efoodregister.client.EfoodUsersClient;
import br.com.vvaug.efoodregister.gateway.EfoodUsersGateway;
import br.com.vvaug.efoodregister.request.RegisterRequest;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EfoodUsersGatewayImpl implements EfoodUsersGateway {

    private final EfoodUsersClient efoodUsersClient;

    @Override
    public void execute(RegisterRequest registerRequest) {
        try {
            efoodUsersClient.register(registerRequest);
            log.info("User registered successfully.");
        } catch (FeignException e){
            log.error("feignException: {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
