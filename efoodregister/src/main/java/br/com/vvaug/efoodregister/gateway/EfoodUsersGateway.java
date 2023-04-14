package br.com.vvaug.efoodregister.gateway;

import br.com.vvaug.efoodregister.request.RegisterRequest;

public interface EfoodUsersGateway {

    void execute(RegisterRequest registerRequest);
}
