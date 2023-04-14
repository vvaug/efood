package br.com.vvaug.efoodusers.resource;

import br.com.vvaug.efoodusers.request.AuthenticationRequest;
import br.com.vvaug.efoodusers.response.JwtTokenResponse;
import br.com.vvaug.efoodusers.usecase.UserAuthenticationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationResource {

    private final UserAuthenticationUseCase userAuthenticationUseCase;
    @PostMapping
    public JwtTokenResponse getAccessToken(@RequestBody AuthenticationRequest authenticationRequest){
        return userAuthenticationUseCase.execute(authenticationRequest);
    }
}
