package com.thedeveloperhive.springbootlazyinitialization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

@SpringBootApplication
public class SpringBootLazyInitializationApplication {

	public static void main(String[] args) {
		System.setProperty("spring.main.lazy-initialization", "true");
		SpringApplication.run(SpringBootLazyInitializationApplication.class, args);
	}

	@Bean
	public RouterFunction<ServerResponse> route() {
		return RouterFunctions.route(GET("/hello"), serverRequest -> ok().syncBody("Hello World!!!!"));
	}

}
