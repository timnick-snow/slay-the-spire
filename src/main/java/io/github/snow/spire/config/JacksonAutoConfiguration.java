package io.github.snow.spire.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.snow.spire.tool.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author snow
 * @since 2023/12/4
 */
@Slf4j
@Configuration
public class JacksonAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperGlobalCustomization() {
        return builder -> {
            log.info("Initialize jackson auto config");
            ObjectMapper newObjectMapper = builder.build();
            JsonUtil.init(newObjectMapper.copy());
        };
    }
}
