package com.modulo5.catalisa4desafio3.exception;

import com.modulo5.catalisa4desafio3.DTO.MensagensErroDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerContasAPagar extends ResponseEntityExceptionHandler {
    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String mensagemUser = messageSource.getMessage("mensagem.invalida", null, null);
        String mensagemDev = ex.getCause().toString();
        return handleExceptionInternal(ex, new MensagemErro(mensagemUser, mensagemDev), headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String mensagem = "";
        for (FieldError campo: ex.getFieldErrors()) {
            mensagem = mensagem + campo.getField() + ": " + campo.getDefaultMessage() + "\n";
        }
        return handleExceptionInternal(ex, new MensagensErroDTO(mensagem), headers, HttpStatus.BAD_REQUEST, request);
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MensagemErro {

        private String mensagemDoUsuario;
        private String mensagemDoDev;
    }
}
