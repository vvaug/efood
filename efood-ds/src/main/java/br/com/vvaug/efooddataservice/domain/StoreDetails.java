package br.com.vvaug.efooddataservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StoreDetails {
    private StoreContact contact;
    private StoreAddress address;
}
