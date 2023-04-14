package br.com.vvaug.efooddataservice.usecase.impl;

import br.com.vvaug.efooddataservice.exception.ApplicationException;
import br.com.vvaug.efooddataservice.gateway.StoresGateway;
import br.com.vvaug.efooddataservice.response.StoreDetailsResponse;
import br.com.vvaug.efooddataservice.usecase.GetDetailsFromStoreUseCase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetDetailsFromStoreUseCaseImpl implements GetDetailsFromStoreUseCase {

    private final StoresGateway storesGateway;
    private final ModelMapper modelMapper;
    @Override
    public StoreDetailsResponse execute(String storeId) {
        return storesGateway.findById(storeId)
                .map(store -> modelMapper.map(store, StoreDetailsResponse.class))
                .orElseThrow(() -> new ApplicationException("Store not found with the entered ID", HttpStatus.NOT_FOUND.value()));
    }
}
