package br.com.vvaug.efoodregister.client;

import br.com.vvaug.efoodregister.request.RegisterRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "efood-users", url = "http://localhost:8080")
public interface EfoodUsersClient {

    @PostMapping("/register")
    void register(@RequestBody RegisterRequest registerRequest);
}
