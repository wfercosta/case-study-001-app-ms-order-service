package com.wfercosta.ms.order.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private Long id;

    @JsonProperty("logradouro")
    private String street;

    @JsonProperty("numero")
    private String number;

    @JsonProperty("complemento")
    private String additionalAddressData;

    @JsonProperty("bairro")
    private String neighborhood;

    @JsonProperty("cidade")
    private String city;

    @JsonProperty("estado")
    private String state;

    @JsonProperty("pais")
    private String country;

    @JsonProperty("cep")
    private String zipcode;

    @JsonProperty("purpose")
    private PurposeType purpose;

    @JsonProperty("regiao")
    private String region;
}
