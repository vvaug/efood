package br.com.vvaug.efood.usecase;

import br.com.vvaug.efood.response.StoreResponse;

import java.util.List;

public interface FindStoresUseCase {

    List<StoreResponse> execute();
}
