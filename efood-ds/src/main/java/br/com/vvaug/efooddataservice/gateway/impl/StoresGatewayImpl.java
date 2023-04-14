package br.com.vvaug.efooddataservice.gateway.impl;

import br.com.vvaug.efooddataservice.entity.Store;
import br.com.vvaug.efooddataservice.gateway.StoresGateway;
import br.com.vvaug.efooddataservice.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoresGatewayImpl implements StoresGateway {

    private final StoreRepository storeRepository;

    @Override
    public List<Store> findAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public Optional<Store> findById(String id) {
        return storeRepository.findById(id);
    }

    @Override
    public Store save(Store store) {
        return storeRepository.save(store);
    }
}
