package com.wfercosta.ms.order.entrypoint.dto;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.wfercosta.ms.order.domain.entity.PurposeType;


public class AddressDtoTemplate implements TemplateLoader {
    public static final String BASIC =  "BASIC";

    @Override
    public void load() {
        Fixture.of(AddressDto.class).addTemplate(BASIC, new Rule(){{
            add("street", "Av do estado");
            add("number","5533");
            add("additionalAddressData","4 andar b");
            add("neighborhood","Mooca");
            add("state","SP");
            add("country","Brasil");
            add("zipcode","03105003");
            add("purpose", PurposeType.ENTREGA);
            add("region","SUDESTE");
        }});
    }
}
