package br.com.vvaug.efoodusers.usecase;

import br.com.vvaug.efoodusers.request.RegisterNewUserRequest;

public interface RegisterNewUserUseCase {

    void execute(RegisterNewUserRequest request);
}
