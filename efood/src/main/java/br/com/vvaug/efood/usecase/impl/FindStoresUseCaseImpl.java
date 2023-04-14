package br.com.vvaug.efood.usecase.impl;

import br.com.vvaug.efood.gateway.FindStoresGateway;
import br.com.vvaug.efood.response.StoreResponse;
import br.com.vvaug.efood.usecase.FindStoresUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class FindStoresUseCaseImpl implements FindStoresUseCase {

    private final FindStoresGateway findStoresGateway;

    @Override
    public List<StoreResponse> execute() {
        return findStoresGateway.findAllStores();
    }
}
