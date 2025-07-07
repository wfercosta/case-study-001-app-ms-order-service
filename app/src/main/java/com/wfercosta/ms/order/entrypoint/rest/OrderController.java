package com.wfercosta.ms.order.entrypoint.rest;

import com.wfercosta.ms.order.domain.entity.Order;
import com.wfercosta.ms.order.domain.usecase.CreateOrderUseCase;
import com.wfercosta.ms.order.entrypoint.dto.OrderDto;
import com.wfercosta.ms.order.entrypoint.dto.ResponseEnvelopDto;
import com.wfercosta.ms.order.entrypoint.mappers.OrderMapper;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    private final CreateOrderUseCase useCase;
    private final OrderMapper mapper = OrderMapper.INSTANCE;

    public OrderController(CreateOrderUseCase useCase) {
        this.useCase = useCase;
    }

    @ResponseStatus(code = CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEnvelopDto<OrderDto> create(@RequestBody OrderDto dto) {
        final Order order = useCase.execute(mapper.toEntity(dto));
        return ResponseEnvelopDto.of(mapper.toDto(order));
    }
}
