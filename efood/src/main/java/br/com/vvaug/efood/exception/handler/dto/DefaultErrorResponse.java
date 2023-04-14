package br.com.vvaug.efood.exception.handler.dto;

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

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class FieldError {
        private String field;
        private String message;
    }
}
