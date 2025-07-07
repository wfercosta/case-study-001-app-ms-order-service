package com.wfercosta.ms.order.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Recipient {

    private Long id;

    @JsonProperty("nome")
    private String name;

    @JsonProperty("tipo_pessoa")
    private PersonType typePerson;

    @JsonProperty("regime_tributacao")
    private TaxationType typeTaxation;

    @JsonProperty("documentos")
    private List<Document> documents;

    @JsonProperty("enderecos")
    private List<Address> addresses;
}

