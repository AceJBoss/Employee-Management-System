package com.jboss.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class EmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmsApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/v1/company/*"))
                .apis(RequestHandlerSelectors.basePackage("com.jboss"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Employee Management System",
                "Sample API for Tutorials",
                "1.0",
                "Free to Use",
                new springfox.documentation.service.Contact("ABOLADE, Akintomiwa","https://twitter.com/devJboss","abolade.akintomiwa@gmail.com"),
                "API License",
                "https://akintomiwa-abolade.com",
                Collections.emptyList());
    }

}
