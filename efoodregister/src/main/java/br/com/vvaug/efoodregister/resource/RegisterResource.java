package br.com.vvaug.efoodregister.resource;

import br.com.vvaug.efoodregister.request.RegisterRequest;
import br.com.vvaug.efoodregister.usecase.RegisterNewUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterResource {

    private final RegisterNewUserUseCase registerNewUserUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegisterRequest registerRequest){
        registerNewUserUseCase.execute(registerRequest);
    }
}
