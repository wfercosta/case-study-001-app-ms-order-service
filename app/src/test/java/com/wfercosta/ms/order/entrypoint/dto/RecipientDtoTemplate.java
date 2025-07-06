package com.wfercosta.ms.order.entrypoint.dto;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.wfercosta.ms.order.domain.entity.PersonType;
import com.wfercosta.ms.order.domain.entity.TaxationType;


public class RecipientDtoTemplate implements TemplateLoader {

    public static final String BASIC =  "BASIC";

    @Override
    public void load() {

        Fixture.of(RecipientDto.class).addTemplate(BASIC, new Rule(){{
            add("name","John Doe");
            add("typePerson", PersonType.JURIDICA);
            add("typeTaxation", TaxationType.SIMNPLES_NACIONAL);
            add("documents", has(1).of(DocumentDto.class, DocumentDtoTemplate.BASIC));
            add("addresses", has(1).of(AddressDto.class, AddressDtoTemplate.BASIC));
        }});

    }
}
