package br.com.vvaug.efoodusers.usecase.impl;

import br.com.vvaug.efoodusers.gateway.EfoodUsersDataServiceGateway;
import br.com.vvaug.efoodusers.request.RegisterNewUserRequest;
import br.com.vvaug.efoodusers.usecase.RegisterNewUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterNewUserUseCaseImpl implements RegisterNewUserUseCase {

    private final EfoodUsersDataServiceGateway efoodUsersDataServiceGateway;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void execute(RegisterNewUserRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        efoodUsersDataServiceGateway.register(request);
    }
}
