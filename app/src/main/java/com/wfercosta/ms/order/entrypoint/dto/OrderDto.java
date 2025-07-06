package com.wfercosta.ms.order.entrypoint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    @JsonProperty("id_pedido")
    private Long id;

    @JsonProperty("data")
    private LocalDate date;

    @JsonProperty("valor_total_itens")
    private BigDecimal valueTotal;

    @JsonProperty("valor_frete")
    private BigDecimal valueShipment;

    @JsonProperty("itens")
    private List<OrderItemDto> items;

    @JsonProperty("destinatario")
    private RecipientDto recipient;

}

