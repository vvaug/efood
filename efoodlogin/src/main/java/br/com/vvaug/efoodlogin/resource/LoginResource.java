package br.com.vvaug.efoodlogin.resource;

import br.com.vvaug.efoodlogin.request.AuthenticationRequest;
import br.com.vvaug.efoodlogin.response.JwtTokenResponse;
import br.com.vvaug.efoodlogin.usecase.LoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/login")
@RestController
public class LoginResource {

    private final LoginUseCase loginUseCase;

    @PostMapping
    public JwtTokenResponse login(@RequestBody AuthenticationRequest authenticationRequest){
        return loginUseCase.execute(authenticationRequest);
    }
}
