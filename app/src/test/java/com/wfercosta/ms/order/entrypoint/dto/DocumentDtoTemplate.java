package com.wfercosta.ms.order.entrypoint.dto;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.wfercosta.ms.order.domain.entity.DocumentType;

public class DocumentDtoTemplate implements TemplateLoader {

    public static final String BASIC =  "BASIC";

    @Override
    public void load() {
        Fixture.of(DocumentDto.class).addTemplate(BASIC, new Rule(){{
            add("type", DocumentType.CNPJ);
            add("number", "49695613000180");
        }});
    }
}


