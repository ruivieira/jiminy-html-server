package com.redhat.analytics.jiminy.htmlserver.config;


import com.redhat.analytics.jiminy.htmlserver.model.Ratings;
import com.redhat.analytics.jiminy.htmlserver.model.RatingsDAO;
import com.redhat.analytics.jiminy.htmlserver.service.RatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = { "com.redhat.analytics.jiminy.htmlserver.controller", "com.redhat.analytics.jiminy.htmlserver.model",
		"com.redhat.analytics.jiminy.htmlserver.service" ,"com.redhat.analytics.jiminy.htmlserver.repository" })
@EnableMongoRepositories(basePackages = { "com.redhat.analytics.jiminy.htmlserver.repository" })
public class JiminyHtmlServerApplication implements CommandLineRunner{

//	@Autowired
//	public RatingService service;

	@Bean
	public Docket coreApi() {
		return new Docket(DocumentationType.SWAGGER_2)
			        .groupName("jiminy-html-server")
			        .apiInfo(new ApiInfoBuilder().title("Jiminy HTML Server")
			        .description("An HTML server for the Jiminy project ")
			        .contact("Zak Hassan <zak.hassan1010@gmail.com")
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

	@Override
	public void run(String... arg0) throws Exception {
//		service.deleteAll();
//		//int userid, int product, double rating
//		service.create(new RatingsDAO(
//				new Ratings(1,1,3.0)
//			)
//		);
//		service.create(new RatingsDAO(
//						new Ratings(2,4,5.0)
//				)
//		);

	}
}
