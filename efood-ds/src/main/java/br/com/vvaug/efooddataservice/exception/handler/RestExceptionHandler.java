package br.com.vvaug.efooddataservice.exception.handler;

import br.com.vvaug.efooddataservice.exception.ApplicationException;
import br.com.vvaug.efooddataservice.exception.handler.dto.DefaultErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<DefaultErrorResponse> handleApplicationException(ApplicationException ex){
        var response = DefaultErrorResponse.builder()
                .message(ex.getMessage())
                .statusCode(ex.getStatusCode())
                .fieldsError(hasFieldErrors(ex) ? ex.getFieldErrors() : null)
                .isIntegrationError(ex.isIntegrationError() == false ? null : ex.isIntegrationError())
                .serviceName(ex.getServiceName() == null ? null : ex.getServiceName())
                .serviceResponse(ex.getServiceResponse() == null ? null : ex.getServiceResponse())
                .build();
        return ResponseEntity.status(ex.getStatusCode()).body(response);
    }

    private boolean hasFieldErrors(ApplicationException ex){
        return Objects.nonNull(ex.getFieldErrors()) && ! ex.getFieldErrors().isEmpty();
    }
}
