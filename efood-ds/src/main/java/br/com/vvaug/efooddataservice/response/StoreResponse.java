package br.com.vvaug.efooddataservice.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StoreResponse {
    private String id;
    private String name;
    private String averageDurationDelivery;
    private Integer likes;
    private Integer dislikes;
}
