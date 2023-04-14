package br.com.vvaug.efoodusers.exception;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ErrorMessageBuilder {

    public static String getMessage(Exception exception){
        var stackTrace = exception.getStackTrace()[0];
        return new StringBuilder(exception.getMessage())
                .append(" | Class: ")
                .append(stackTrace.getClassName())
                .append(" | Line: ")
                .append(stackTrace.getLineNumber())
                .append(" | Method: ")
                .append(stackTrace.getMethodName())
                .toString();
    }
}
