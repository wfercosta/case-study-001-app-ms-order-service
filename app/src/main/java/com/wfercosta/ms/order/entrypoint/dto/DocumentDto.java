package com.wfercosta.ms.order.entrypoint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wfercosta.ms.order.domain.entity.DocumentType;
import lombok.*;

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDto {

    private Long id;

    @JsonProperty("tipo")
    private DocumentType type;

    @JsonProperty("numero")
    private String number;
}

