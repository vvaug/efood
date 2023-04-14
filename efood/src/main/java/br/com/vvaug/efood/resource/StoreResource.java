package br.com.vvaug.efood.resource;

import br.com.vvaug.efood.response.StoreResponse;
import br.com.vvaug.efood.usecase.FindStoresUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreResource {

    private final FindStoresUseCase findStoresUseCase;

    @GetMapping
    public List<StoreResponse> findAllStores(){
        return findStoresUseCase.execute();
    }

}
