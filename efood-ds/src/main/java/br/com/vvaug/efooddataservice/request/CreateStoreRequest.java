package br.com.vvaug.efooddataservice.request;

import br.com.vvaug.efooddataservice.domain.StoreDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.context.annotation.RequestScope;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@RequestScope
public class CreateStoreRequest {

    private String name;
    private String averageDurationDelivery;
    private StoreDetails details;
}
