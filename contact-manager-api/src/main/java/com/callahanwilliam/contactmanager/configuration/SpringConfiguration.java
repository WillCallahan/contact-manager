package com.callahanwilliam.contactmanager.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.callahanwilliam.contactmanager")
public class SpringConfiguration {
	
}
