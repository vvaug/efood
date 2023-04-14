package br.com.vvaug.efooddataservice.usecase.impl;

import br.com.vvaug.efooddataservice.gateway.StoresGateway;
import br.com.vvaug.efooddataservice.response.StoreResponse;
import br.com.vvaug.efooddataservice.usecase.FindAllStoresUseCase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllStoresUseCaseImpl implements FindAllStoresUseCase {

    private final StoresGateway storesGateway;
    private final ModelMapper modelMapper;

    @Override
    public List<StoreResponse> execute() {
        return storesGateway.findAllStores()
                .stream().map(store -> modelMapper.map(store, StoreResponse.class))
                .toList();
    }
}
