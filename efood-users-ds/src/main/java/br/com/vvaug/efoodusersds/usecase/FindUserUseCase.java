package br.com.vvaug.efoodusersds.usecase;

import br.com.vvaug.efoodusersds.request.FindUserRequest;
import br.com.vvaug.efoodusersds.response.UserResponse;

public interface FindUserUseCase {

    UserResponse execute(FindUserRequest userRequest);
}
