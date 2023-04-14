package br.com.vvaug.efooddataservice.resource;

import br.com.vvaug.efooddataservice.request.CreateStoreRequest;
import br.com.vvaug.efooddataservice.response.StoreDetailsResponse;
import br.com.vvaug.efooddataservice.response.StoreResponse;
import br.com.vvaug.efooddataservice.usecase.CreateStoreUseCase;
import br.com.vvaug.efooddataservice.usecase.FindAllStoresUseCase;
import br.com.vvaug.efooddataservice.usecase.GetDetailsFromStoreUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreResource {

    private final FindAllStoresUseCase findAllStoresUseCase;
    private final GetDetailsFromStoreUseCase getDetailsFromStoreUseCase;
    private final CreateStoreUseCase createStoreUseCase;

    @GetMapping
    public List<StoreResponse> findAllStores(@RequestHeader(name = HttpHeaders.AUTHORIZATION, required = false) String Authorization){
        return findAllStoresUseCase.execute();
    }

    @GetMapping("/{storeId}/details")
    public StoreDetailsResponse getDetailsFromStore(@RequestHeader(name = HttpHeaders.AUTHORIZATION, required = false) String Authorization,
                                                    @PathVariable("storeId") String storeId){
        return getDetailsFromStoreUseCase.execute(storeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStore(@RequestHeader(name = HttpHeaders.AUTHORIZATION, required = false) String Authorization,
                             @RequestBody CreateStoreRequest createStoreRequest){
        createStoreUseCase.execute(createStoreRequest);
    }
    @GetMapping("/{storeId}/products")
    public Object findStoreProducts(@RequestHeader(name = HttpHeaders.AUTHORIZATION, required = false) String Authorization,
                                  @PathVariable String storeId){
        return null;
    }
    @PostMapping("/{storeId}/add-product")
    public void addProductToStore(@RequestHeader(name = HttpHeaders.AUTHORIZATION, required = false) String Authorization,
                                  @PathVariable String storeId){
        return;
    }
}
