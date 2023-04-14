package br.com.vvaug.efood.exception;

import br.com.vvaug.efood.exception.handler.dto.DefaultErrorResponse;
import lombok.Getter;

import java.util.List;

@Getter
public class ApplicationException extends RuntimeException {

    private Integer statusCode;
    private List<DefaultErrorResponse.FieldError> fieldErrors;
    private boolean isIntegrationError;
    private String serviceName;
    private Object serviceResponse;

    public ApplicationException(String message, Integer statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public ApplicationException(String message, Integer statusCode, List<DefaultErrorResponse.FieldError> fieldErrors) {
        super(message);
        this.statusCode = statusCode;
        this.fieldErrors = fieldErrors;
    }

    public ApplicationException(String message, Integer statusCode, List<DefaultErrorResponse.FieldError> fieldErrors, boolean isIntegrationError, String serviceName, Object serviceResponse) {
        super(message);
        this.statusCode = statusCode;
        this.fieldErrors = fieldErrors;
        this.isIntegrationError = isIntegrationError;
        this.serviceName = serviceName;
        this.serviceResponse = serviceResponse;
    }
}
