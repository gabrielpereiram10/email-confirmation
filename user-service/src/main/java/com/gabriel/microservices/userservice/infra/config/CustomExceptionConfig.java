package com.gabriel.microservices.userservice.infra.config;

import com.gabriel.microservices.userservice.application.UserAlreadyExistsException;
import com.gabriel.microservices.userservice.domain.InvalidFieldException;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomExceptionConfig extends DefaultErrorAttributes {

    public CustomExceptionConfig() {
        super();
    }

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(
                webRequest,
                options.excluding(
                        ErrorAttributeOptions.Include.STACK_TRACE,
                        ErrorAttributeOptions.Include.MESSAGE
                )
        );

        Throwable throwable = getError(webRequest);
        Throwable cause = throwable.getCause();
        if (cause != null) {
            Map<String, Object> causeErrorAttributes = new HashMap<>();
            causeErrorAttributes.put("exception", cause.getClass().getName());
            causeErrorAttributes.put("message", cause.getMessage());
            if (cause.getClass().equals(InvalidFieldException.class)) {
                causeErrorAttributes.put("field", ((InvalidFieldException) cause).getFiled());
            }

            if (cause.getClass().equals(UserAlreadyExistsException.class)) {
                causeErrorAttributes.put("param", ((UserAlreadyExistsException) cause).getProperty());
            }
            errorAttributes.put("cause", causeErrorAttributes);

        }
        return errorAttributes;
    }
}
