package com.wfercosta.ms.order.entrypoint.dto;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.math.BigDecimal;

public class OrderItemDtoTemplate implements TemplateLoader {

    public static final String BASIC =  "BASIC";

    @Override
    public void load() {
        Fixture.of(OrderItemDto.class).addTemplate(BASIC, new Rule(){{
            add("description","Monitor LCD SAMSUNG");
            add("value", BigDecimal.valueOf(730));
            add("amount", 8);
        }});
    }
}


