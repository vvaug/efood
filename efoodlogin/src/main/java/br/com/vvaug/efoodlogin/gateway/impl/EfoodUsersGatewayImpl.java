package br.com.vvaug.efoodlogin.gateway.impl;

import br.com.vvaug.efoodlogin.client.EfoodUsersClient;
import br.com.vvaug.efoodlogin.gateway.EfoodUsersGateway;
import br.com.vvaug.efoodlogin.request.AuthenticationRequest;
import br.com.vvaug.efoodlogin.response.JwtTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EfoodUsersGatewayImpl implements EfoodUsersGateway {

    private final EfoodUsersClient efoodUsersClient;

    @Override
    public JwtTokenResponse execute(AuthenticationRequest authenticationRequest) {
        return efoodUsersClient.getAccessToken(authenticationRequest);
    }
}
