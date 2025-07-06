package com.wfercosta.ms.order.entrypoint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wfercosta.ms.order.domain.entity.PersonType;
import com.wfercosta.ms.order.domain.entity.TaxationType;
import lombok.*;

import java.util.List;

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class RecipientDto {

    private Long id;

    @JsonProperty("nome")
    private String name;

    @JsonProperty("tipo_pessoa")
    private PersonType typePerson;

    @JsonProperty("regime_tributacao")
    private TaxationType typeTaxation;

    @JsonProperty("documentos")
    private List<DocumentDto> documents;

    @JsonProperty("enderecos")
    private List<AddressDto> addresses;
}

