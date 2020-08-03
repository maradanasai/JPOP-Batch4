package com.jpop4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class UserServiceApplication {

    public static final String API_INFO_TITLE = "User-service Api";
    public static final String API_INFO_DESCRIPTION = "JPOP #4 assignments";
    public static final String API_INFO_VERSION = "1.0";
    public static final String CONTACT_INFO = "Rajeev Marrapu";
    public static final String CONTACT_EMAIL = "Rajeev_Marrapu@epam.com";
    public static final String API_INFO_TERMS_OF_SERVICE_URL = "";
    public static final String CONTACT_URL = "";
    public static final String CONTACT_LICENSE = "";
    public static final String CONTACT_LICENSE_URL = "";

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jpop4"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                API_INFO_TITLE,
                API_INFO_DESCRIPTION,
                API_INFO_VERSION,
                API_INFO_TERMS_OF_SERVICE_URL,

                new Contact(
                        CONTACT_INFO,
                        CONTACT_URL,
                        CONTACT_EMAIL
                ),

                CONTACT_LICENSE,
                CONTACT_LICENSE_URL,
                Collections.emptyList()
        );
    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
