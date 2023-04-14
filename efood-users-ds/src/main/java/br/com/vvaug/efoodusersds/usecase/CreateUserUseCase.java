package br.com.vvaug.efoodusersds.usecase;

import br.com.vvaug.efoodusersds.request.CreateUserRequest;

public interface CreateUserUseCase {

    void execute(CreateUserRequest createUserRequest);
}
