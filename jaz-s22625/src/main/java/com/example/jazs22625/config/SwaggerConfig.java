package com.example.jazs22625.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.jaz-s22625"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Kolokwium projekt s22625, api NBP")
                .description("Wyświetlenie użytkownikowi liczby walut (z tabeli A) przekraczających kiedykolwiek daną\n" +
                        "(przez użytkownika) średnią ceną biorąc pod uwagę dane z przedziału od YYYY-MM-DD\n" +
                        "do YYYY-MM-DD, z wykorzystaniem do tego api NBP")
                .contact(new Contact("Igor",
                        "pjatk.com",
                        "s22625@pjwstk.edu.pl"))
                .version("1.0.0")
                .build();
    }
}

