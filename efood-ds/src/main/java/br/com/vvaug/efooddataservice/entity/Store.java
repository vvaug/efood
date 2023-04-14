package br.com.vvaug.efooddataservice.entity;

import br.com.vvaug.efooddataservice.domain.StoreDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stores")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Store {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String averageDurationDelivery;
    @Builder.Default
    private Integer likes = 0;
    @Builder.Default
    private Integer dislikes = 0;
    private StoreDetails details;
}
