package com.kingmj.api.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi accountApi() {
        return GroupedOpenApi.builder()
                             .group("계정 관련 API")
                             .pathsToMatch("/api/v1/accounts/**")
                             .build();
    }

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI().info(new Info().title("KINGMJ DIARY")
                                            .description("킹명주 일기장입니다."));
    }

}
