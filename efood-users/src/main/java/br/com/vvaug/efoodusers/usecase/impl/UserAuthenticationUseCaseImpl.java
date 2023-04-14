package br.com.vvaug.efoodusers.usecase.impl;

import br.com.vvaug.efoodusers.exception.ApplicationException;
import br.com.vvaug.efoodusers.request.AuthenticationRequest;
import br.com.vvaug.efoodusers.response.JwtTokenResponse;
import br.com.vvaug.efoodusers.usecase.GenerateAccessTokenUseCase;
import br.com.vvaug.efoodusers.usecase.UserAuthenticationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserAuthenticationUseCaseImpl implements UserAuthenticationUseCase {

    private final GenerateAccessTokenUseCase generateAccessTokenUseCase;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtTokenResponse execute(AuthenticationRequest authenticationRequest) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        if (authentication.isAuthenticated())
            return generateAccessTokenUseCase.execute(authentication);
        throw new ApplicationException("An error occurred while trying to authenticate", HttpStatus.FORBIDDEN.value());
    }
}
