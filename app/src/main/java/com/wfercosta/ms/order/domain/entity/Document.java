package com.wfercosta.ms.order.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Document {

    private Long id;

    @JsonProperty("tipo")
    private DocumentType type;

    @JsonProperty("numero")
    private String number;
}

