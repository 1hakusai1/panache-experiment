package me.oishi.interceptor;

import javax.enterprise.context.ApplicationScoped;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.jackson.ObjectMapperCustomizer;

@ApplicationScoped
public class EnablePrivateFieldSerialization implements ObjectMapperCustomizer {

    @Override
    public void customize(ObjectMapper objectMapper) {
        objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
    }

}
