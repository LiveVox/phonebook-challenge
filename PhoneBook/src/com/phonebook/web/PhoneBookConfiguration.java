package com.phonebook.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
 
@Configuration
@ComponentScan("com.phonebook.*")
@EnableWebMvc
public class PhoneBookConfiguration  extends WebMvcConfigurerAdapter implements WebMvcConfigurer {
     
    @Bean
     public InternalResourceViewResolver getInternalResourceViewResolver() {
	     InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	     resolver.setPrefix("/WEB-INF/views/");
	     resolver.setSuffix(".jsp");
	     return resolver;
    }
    
    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry
	      .addResourceHandler("/resources/**")
	      .addResourceLocations("/resources/");	
	}
}