package br.com.vvaug.efooddataservice.exception.handler.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DefaultErrorResponse {

    private String message;
    private Integer statusCode;
    private List<FieldError> fieldsError;
    private Boolean isIntegrationError;
    private String serviceName;
    private Object serviceResponse;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class FieldError {
        private String field;
        private String message;
    }
}
