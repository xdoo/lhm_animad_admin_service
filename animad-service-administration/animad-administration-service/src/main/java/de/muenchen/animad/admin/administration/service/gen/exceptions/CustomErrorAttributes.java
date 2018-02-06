package de.muenchen.animad.admin.administration.service.gen.exceptions;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);

        Throwable throwable = getError(requestAttributes);
        
        if (throwable instanceof TooManyResultsException) {
            TooManyResultsException e = (TooManyResultsException) throwable;
            errorAttributes.put("maxResults", e.getMaxResults());
        }
        return errorAttributes;
    }
}