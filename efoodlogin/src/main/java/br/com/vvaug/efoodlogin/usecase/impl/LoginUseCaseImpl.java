package br.com.vvaug.efoodlogin.usecase.impl;

import br.com.vvaug.efoodlogin.gateway.EfoodUsersGateway;
import br.com.vvaug.efoodlogin.request.AuthenticationRequest;
import br.com.vvaug.efoodlogin.response.JwtTokenResponse;
import br.com.vvaug.efoodlogin.usecase.LoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {

    private final EfoodUsersGateway efoodUsersGateway;

    @Override
    public JwtTokenResponse execute(AuthenticationRequest authenticationRequest) {
        return efoodUsersGateway.execute(authenticationRequest);
    }
}
