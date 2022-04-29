package com.velmar.blog_spring_boot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Long resourceValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Long resourceValue) {
        super(String.format("%s Not found with: %s : '%s'",resourceName,fieldName,resourceValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.resourceValue = resourceValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Long getResourceValue() {
        return resourceValue;
    }

    public void setResourceValue(Long resourceValue) {
        this.resourceValue = resourceValue;
    }
}
