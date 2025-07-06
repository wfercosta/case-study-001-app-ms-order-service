package com.wfercosta.ms.order.entrypoint.dto;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderDtoTemplate implements TemplateLoader {

    public static final String BASIC =  "BASIC";

    @Override
    public void load() {
        Fixture.of(OrderDto.class).addTemplate(BASIC, new Rule(){{
            add("date",LocalDate.of(2022, 5,1) );
            add("valueTotal", BigDecimal.valueOf(5840.0));
            add("valueShipment", BigDecimal.valueOf(72.0));
            add("items", has(1).of(OrderItemDto.class, OrderItemDtoTemplate.BASIC));
            add("recipient", one(RecipientDto.class, RecipientDtoTemplate.BASIC));
        }});
    }
}

