package com.wfercosta.ms.order.entrypoint.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseEnvelopDto<E>  {

    private E data;
    private List<String> messages;

    public ResponseEnvelopDto(E data) {
        this.data = data;
    }

    public ResponseEnvelopDto(List<String> messages) {
        this.messages = messages;
    }

    public static <R> ResponseEnvelopDto<R> of(R data) {
        return new ResponseEnvelopDto<>(data);
    }

    public static ResponseEnvelopDto<?> createInternalServerError() {
        return new ResponseEnvelopDto<>(Collections.singletonList("INTERNAL SERVER ERROR"));
    }

    public static ResponseEnvelopDto<?> ofMessages(List<String> messages) {
        return new ResponseEnvelopDto<>(messages);
    }

}
