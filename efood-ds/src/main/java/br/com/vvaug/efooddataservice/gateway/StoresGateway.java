package br.com.vvaug.efooddataservice.gateway;

import br.com.vvaug.efooddataservice.entity.Store;

import java.util.List;
import java.util.Optional;

public interface StoresGateway {

    List<Store> findAllStores();

    Optional<Store> findById(String id);

    Store save(Store store);
}
