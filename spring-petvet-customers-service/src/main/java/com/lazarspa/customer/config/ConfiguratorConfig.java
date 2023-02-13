package com.lazarspa.customer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.List;

@Configuration
public class ConfiguratorConfig {

    @Bean
    public ObjectMapper objectMapper(List<Jackson2ObjectMapperBuilder> mapperBuilders) {
        ObjectMapper objectMapper = new Jackson2ObjectMapperBuilder().featuresToDisable(
                        SerializationFeature.FAIL_ON_EMPTY_BEANS).build();

        mapperBuilders.stream().forEach(builder -> builder.configure(objectMapper));
        return objectMapper;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(ObjectMapper om) {
        MappingJackson2HttpMessageConverter bean = new MappingJackson2HttpMessageConverter();
        bean.setObjectMapper(om);
        return bean;
    }
}
