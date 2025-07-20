package com.yugrow.dree.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
@EnableCaching
public class AppConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(Collections.singletonList(
                        new Server().url("/ap1/v1").description("HTTPS Server")
                ))
                .info(new Info()
                        .title("Dynamic Rule Evaluation Service APIS")
                        .version("1.0.0")
                        .description("API documentation without authentication"));
    }
}
