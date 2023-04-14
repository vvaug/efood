package br.com.vvaug.efoodlogin.client;

import br.com.vvaug.efoodlogin.request.AuthenticationRequest;
import br.com.vvaug.efoodlogin.response.JwtTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "efood-users", url = "http://localhost:8080")
public interface EfoodUsersClient {

    @PostMapping("/auth")
    JwtTokenResponse getAccessToken(@RequestBody AuthenticationRequest authenticationRequest);
}
