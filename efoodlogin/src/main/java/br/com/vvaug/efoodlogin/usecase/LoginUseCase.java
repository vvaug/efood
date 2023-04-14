package br.com.vvaug.efoodlogin.usecase;

import br.com.vvaug.efoodlogin.request.AuthenticationRequest;
import br.com.vvaug.efoodlogin.response.JwtTokenResponse;

public interface LoginUseCase {

    JwtTokenResponse execute(AuthenticationRequest authenticationRequest);
}
