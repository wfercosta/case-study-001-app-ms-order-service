package com.wfercosta.ms.order.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @JsonProperty("id_item")
    private Long id;

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("valor_unitario")
    private BigDecimal value;

    @JsonProperty("quantidade")
    private Integer amount;
}
