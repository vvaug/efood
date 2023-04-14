package br.com.vvaug.efooddataservice.usecase.impl;

import br.com.vvaug.efooddataservice.entity.Store;
import br.com.vvaug.efooddataservice.exception.ApplicationException;
import br.com.vvaug.efooddataservice.gateway.StoresGateway;
import br.com.vvaug.efooddataservice.request.CreateStoreRequest;
import br.com.vvaug.efooddataservice.usecase.CreateStoreUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateStoreUseCaseImpl implements CreateStoreUseCase {

    private final StoresGateway storesGateway;
    private final ModelMapper modelMapper;

    private static final String DUPLICATE_NAME_EXCEPTION = "Erro ao criar novo estabelecimento no efood. Já existe um estabelecimento com este nome";
    @Override
    public void execute(CreateStoreRequest createStoreRequest) {
        var store = modelMapper.map(createStoreRequest, Store.class);
        try {
            storesGateway.save(store);
        } catch (DuplicateKeyException ex) {
            log.error(DUPLICATE_NAME_EXCEPTION);
            throw new ApplicationException(DUPLICATE_NAME_EXCEPTION, HttpStatus.BAD_REQUEST.value());
        } catch (Exception ex){
            throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR.name(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
