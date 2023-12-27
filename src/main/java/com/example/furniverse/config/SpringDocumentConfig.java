package com.example.furniverse.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SpringDocumentConfig {

    @Bean
    public OpenAPI openApi(){
        return new OpenAPI().info(new Info().title("Aytac Mammadli terefinden documentasiya")
                .version("0.0.1").description("bu servis mebel magazasi sayti ucun yazilmisdir").
                contact(new Contact().url("www.furniverse.az").email("furniverse@gmail.com").name("Aytac Mammadli")));
    }

}
