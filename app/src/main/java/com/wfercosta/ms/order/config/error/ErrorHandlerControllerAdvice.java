package com.wfercosta.ms.order.config.error;

import com.wfercosta.ms.order.config.error.exception.ApplicationException;
import com.wfercosta.ms.order.entrypoint.dto.ResponseEnvelopDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class ErrorHandlerControllerAdvice {

    @ExceptionHandler(ApplicationException
            .class)
    public ResponseEntity<ResponseEnvelopDto<?>> applicationException(ApplicationException exception) {
        return ResponseEntity.unprocessableEntity()
                .body(ResponseEnvelopDto.ofMessages(Collections.singletonList(exception.getMessage())));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseEnvelopDto<?>> constraintViolationException(final MethodArgumentNotValidException exception) {
        final List<String> messages = exception.getBindingResult().getFieldErrors()
                .stream()
                .map(field -> String.format("Field with name %s has an error: %s", field.getField(), field.getDefaultMessage()))
                .collect(Collectors.toList());

        return ResponseEntity.badRequest()
                .body(ResponseEnvelopDto.ofMessages(messages));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseEnvelopDto<?>> defaultHandler() {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                .body(ResponseEnvelopDto.createInternalServerError());
    }
}
