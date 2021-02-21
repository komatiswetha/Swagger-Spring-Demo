package com.example.springSwagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2

public class SwaggerConfig
{
    @Bean
   public Docket docket()
        {
         return new Docket(DocumentationType.SWAGGER_2)
                 .select()
                .paths(PathSelectors.ant("/api/*"))
                 .apis(RequestHandlerSelectors.basePackage("com.example"))
                 .build()
                 .apiInfo(apiUser());

        }

    private ApiInfo apiUser() {
        return new ApiInfo(
              "User Info Details",
                "Swagger Tutorial",
                "1.0",
                "free to use",
                new springfox.documentation.service.Contact("swetha reddy","www.googgle.com","abc@gmail.com"),
                "API License",
                "http://localhost:8080",
                Collections.emptyList());

    }

}
