package br.com.vvaug.efoodusersds.exception;

import br.com.vvaug.efoodusersds.exception.handler.dto.DefaultErrorResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class ApplicationException extends RuntimeException {

    private Integer statusCode;
    private List<DefaultErrorResponse.FieldError> fieldErrors;

    public ApplicationException(String message, Integer statusCode, List<DefaultErrorResponse.FieldError> fieldErrors) {
        super(message);
        this.statusCode = statusCode;
        this.fieldErrors = fieldErrors;
    }
}
