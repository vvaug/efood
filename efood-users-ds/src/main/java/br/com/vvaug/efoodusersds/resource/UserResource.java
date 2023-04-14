package br.com.vvaug.efoodusersds.resource;

import br.com.vvaug.efoodusersds.request.CreateUserRequest;
import br.com.vvaug.efoodusersds.request.FindUserRequest;
import br.com.vvaug.efoodusersds.response.UserResponse;
import br.com.vvaug.efoodusersds.usecase.CreateUserUseCase;
import br.com.vvaug.efoodusersds.usecase.FindUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserResource {

    private final FindUserUseCase findUserUseCase;
    private final CreateUserUseCase createUserUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateUserRequest createUserRequest){
        createUserUseCase.execute(createUserRequest);
    }
    @PostMapping("/find")
    public UserResponse findUser(@RequestBody FindUserRequest userRequest){
        return findUserUseCase.execute(userRequest);
    }


}
