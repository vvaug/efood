package br.com.vvaug.efoodusers.client;

import br.com.vvaug.efoodusers.request.FindUserRequest;
import br.com.vvaug.efoodusers.request.RegisterNewUserRequest;
import br.com.vvaug.efoodusers.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "efood-users-ds-client", url = "http://localhost:8083/user")
public interface EfoodUsersDataServiceClient {

    @PostMapping("/find")
    UserResponse findUser(@RequestBody FindUserRequest userRequest);

    @PostMapping
    void create(@RequestBody RegisterNewUserRequest request);
}
