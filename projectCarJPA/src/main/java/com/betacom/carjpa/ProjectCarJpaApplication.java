package com.betacom.carjpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class ProjectCarJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectCarJpaApplication.class, args);
	}

	@Bean 
	@Scope("prototype") 
	Logger log(InjectionPoint injectionPoint) {
		return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
	}
}
