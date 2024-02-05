package com.todoapp.todoapp.context;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    // CONFIGURACIÓN PARA SWAGGER CON SPRING BOOT v3
    // URL para acceder a swagger: http://localhost:8080/swagger-ui/index.html

    @Value("${spring.openapi.local-url}")
    private String localUrl;

    @Value("${spring.openapi.dev-url}")
    private String devUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server prodServer = new Server();
        prodServer.setUrl(localUrl);
        prodServer.setDescription("Server URL in Local environment");

        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("Example-email: myeaddress@company.com");
        contact.setName("Example-name: nombre");
        contact.setUrl("Example-url: www.example.com");

        License mitLicense = new License()
                .name("Example-license: License of API")
                .url("Example-licenceUrl: API license URL");

        Info info = new Info()
                .title("Example-tittle: Todo API")
                .version("Example-version: v1")
                .contact(contact)
                .description("Example-description: La API REST de ToDo App")
                .termsOfService("Example-termsOfServiceUrl: Terms of service")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }

}
