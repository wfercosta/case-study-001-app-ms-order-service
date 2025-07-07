package com.wfercosta.ms.order.entrypoint.mappers;

import com.wfercosta.ms.order.domain.entity.Order;
import com.wfercosta.ms.order.entrypoint.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toEntity(OrderDto order);
    OrderDto toDto(Order order);
}
