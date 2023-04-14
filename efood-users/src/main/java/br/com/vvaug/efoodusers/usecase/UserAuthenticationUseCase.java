package br.com.vvaug.efoodusers.usecase;

import br.com.vvaug.efoodusers.request.AuthenticationRequest;
import br.com.vvaug.efoodusers.response.JwtTokenResponse;

public interface UserAuthenticationUseCase {
    JwtTokenResponse execute(AuthenticationRequest authenticationRequest);
}
