package com.redhat.analytics.jiminy.htmlserver.config;


import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.redhat.analytics.jiminy.htmlserver.repository"})
@ComponentScan(basePackages = { "com.redhat.analytics.jiminy.htmlserver.controller", "com.redhat.analytics.jiminy.htmlserver.model",
		"com.redhat.analytics.jiminy.htmlserver.service" ,"com.redhat.analytics.jiminy.htmlserver.repository" })
@EnableConfigurationProperties
@EntityScan("com.redhat.analytics.jiminy.htmlserver.*")  
public class JiminyHtmlServerApplication  {

	
	
	@Bean
	public Docket coreApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("jiminy-html-server")
				.apiInfo(new ApiInfoBuilder().title("Jiminy HTML Server")
						.description("An HTML server for the Jiminy project ")
						.version("1.0.0-SNAPSHOT")
						.build())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(regex("/api.*"))
				.build();
}

	public static void main(String[] args) {
		SpringApplication.run(JiminyHtmlServerApplication.class, args);
	}

}
