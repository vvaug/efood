package br.com.vvaug.efoodusers.gateway;

import br.com.vvaug.efoodusers.request.FindUserRequest;
import br.com.vvaug.efoodusers.request.RegisterNewUserRequest;
import br.com.vvaug.efoodusers.response.UserResponse;

public interface EfoodUsersDataServiceGateway {

    UserResponse findUser(String username);

    void register(RegisterNewUserRequest request);
}
