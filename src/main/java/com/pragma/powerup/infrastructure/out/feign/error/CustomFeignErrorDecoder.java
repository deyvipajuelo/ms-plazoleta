package com.pragma.powerup.infrastructure.out.feign.error;

import com.pragma.powerup.infrastructure.exception.ExternalResourceNotFoundException;
import com.pragma.powerup.infrastructure.exception.ExternalServiceException;
import com.pragma.powerup.infrastructure.exception.ExternalInvalidRequestException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomFeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 400 -> new ExternalInvalidRequestException();
            case 404 -> new ExternalResourceNotFoundException();
            case 500 -> new ExternalServiceException();
            default -> new ExternalServiceException();
        };
    }
}
