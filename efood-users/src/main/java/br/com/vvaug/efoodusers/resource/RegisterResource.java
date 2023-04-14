package br.com.vvaug.efoodusers.resource;

import br.com.vvaug.efoodusers.request.RegisterNewUserRequest;
import br.com.vvaug.efoodusers.usecase.RegisterNewUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterResource {

    private final RegisterNewUserUseCase registerNewUserUseCase;

    @PostMapping
    public void register(@RequestBody RegisterNewUserRequest request){
        registerNewUserUseCase.execute(request);
    }
}
