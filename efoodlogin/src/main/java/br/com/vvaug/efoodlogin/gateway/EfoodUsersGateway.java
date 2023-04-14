package br.com.vvaug.efoodlogin.gateway;

import br.com.vvaug.efoodlogin.request.AuthenticationRequest;
import br.com.vvaug.efoodlogin.response.JwtTokenResponse;

public interface EfoodUsersGateway {

    JwtTokenResponse execute(AuthenticationRequest authenticationRequest);
}
