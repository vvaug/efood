package br.com.vvaug.efoodregister.usecase;

import br.com.vvaug.efoodregister.request.RegisterRequest;

public interface RegisterNewUserUseCase {

    void execute(RegisterRequest registerRequest);
}
