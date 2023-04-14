package br.com.vvaug.efooddataservice.usecase;

import br.com.vvaug.efooddataservice.response.StoreResponse;

import java.util.List;

public interface FindAllStoresUseCase {

    List<StoreResponse> execute();
}
