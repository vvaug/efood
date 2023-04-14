package br.com.vvaug.efooddataservice.usecase;

import br.com.vvaug.efooddataservice.request.CreateStoreRequest;

public interface CreateStoreUseCase {

    void execute(CreateStoreRequest createStoreRequest);
}
