package br.com.vvaug.efood.gateway;

import br.com.vvaug.efood.response.StoreResponse;

import java.util.List;

public interface FindStoresGateway {

    List<StoreResponse> findAllStores();
}
