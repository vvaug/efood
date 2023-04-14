package br.com.vvaug.efood.gateway;

import br.com.vvaug.efood.client.EfoodDataServiceClient;
import br.com.vvaug.efood.response.StoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FindStoresGatewayImpl implements FindStoresGateway {

    private final EfoodDataServiceClient efoodDataServiceClient;

    @Override
    public List<StoreResponse> findAllStores() {
        return efoodDataServiceClient.findAllStores();
    }
}
