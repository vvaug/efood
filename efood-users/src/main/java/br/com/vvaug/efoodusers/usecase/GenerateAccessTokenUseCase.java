package br.com.vvaug.efoodusers.usecase;

import br.com.vvaug.efoodusers.response.JwtTokenResponse;
import org.springframework.security.core.Authentication;

public interface GenerateAccessTokenUseCase {

    JwtTokenResponse execute(Authentication authentication);
}
