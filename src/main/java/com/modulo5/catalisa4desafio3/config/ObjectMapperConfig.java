package com.modulo5.catalisa4desafio3.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ObjectMapperConfig {

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        return new ObjectMapper().findAndRegisterModules().registerModule(new JavaTimeModule()).disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE).setSerializationInclusion(JsonInclude.Include.NON_NULL).enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
}
