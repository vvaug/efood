package br.com.vvaug.efooddataservice.usecase;

import br.com.vvaug.efooddataservice.response.StoreDetailsResponse;

public interface GetDetailsFromStoreUseCase {

    StoreDetailsResponse execute(String storeId);
}
