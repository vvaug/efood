package br.com.vvaug.efoodusersds.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Address {

    private String id;
    private String street;
    private String number;
    private Boolean mainAddress;
}
