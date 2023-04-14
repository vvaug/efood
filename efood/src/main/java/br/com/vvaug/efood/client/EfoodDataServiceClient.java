package br.com.vvaug.efood.client;

import br.com.vvaug.efood.response.StoreResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "${clients.store-data-service.name}", url = "${clients.store-data-service.url}")
public interface EfoodDataServiceClient {

    @GetMapping("/stores")
    List<StoreResponse> findAllStores();
}
