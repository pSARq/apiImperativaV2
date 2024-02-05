/*
package com.todoapp.todoapp.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // CONFIGURACIÓN PARA SWAGGER 2 CON SPRING BOOT v2
    // URL para acceder a swagger: http://localhost:8080/swagger-ui.html

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.todoapp.todoapp.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Example-tittle: Todo API",
                "Example-description: La API REST de ToDo App",
                "Example-version: v1",
                "Example-termsOfServiceUrl: Terms of service",
                new Contact("Example-name: nombre", "Example-url: www.example.com", "Example-email: myeaddress@company.com"),
                "Example-license: License of API",
                "Example-licenceUrl: API license URL",
                Collections.emptyList()
        );
    }



}
*/
