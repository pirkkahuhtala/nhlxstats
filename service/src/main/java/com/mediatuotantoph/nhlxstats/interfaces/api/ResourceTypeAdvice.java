package com.mediatuotantoph.nhlxstats.interfaces.api;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Class for advice which determines from rest api response result type which
 * resource type should be for the response content-type.
 * 
 * @author Pirkka Huhtala
 *
 */
@ControllerAdvice
public class ResourceTypeAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParam, MediaType arg2,
            Class<? extends HttpMessageConverter<?>> arg3, ServerHttpRequest arg4, ServerHttpResponse response) {
        Class<?> type = methodParam.getParameterType();
        String contentType;
        if (Iterable.class.isAssignableFrom(type)) {
            contentType = ResourceTypes.COLLECTION;
        } else {
            contentType = ResourceTypes.SINGLETON;
        }
        String charset = methodParam.getContainingClass().getAnnotation(RestResource.class).charset();
        response.getHeaders().set("Content-Type", contentType + "charset:" + charset + ";");
        return body;
    }

    @Override
    public boolean supports(MethodParameter arg0, Class<? extends HttpMessageConverter<?>> arg1) {
        return arg0.getContainingClass().isAnnotationPresent(RestResource.class);
    }
}