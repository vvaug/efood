package br.com.vvaug.efoodregister.usecase.impl;

import br.com.vvaug.efoodregister.client.EfoodUsersClient;
import br.com.vvaug.efoodregister.gateway.EfoodUsersGateway;
import br.com.vvaug.efoodregister.request.RegisterRequest;
import br.com.vvaug.efoodregister.usecase.RegisterNewUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterNewUseCaseImpl implements RegisterNewUserUseCase {

    private final EfoodUsersGateway efoodUsersGateway;

    @Override
    public void execute(RegisterRequest registerRequest) {
        efoodUsersGateway.execute(registerRequest);
    }
}
