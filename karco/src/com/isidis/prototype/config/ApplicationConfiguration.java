package com.isidis.prototype.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackageClasses = CustomWebApplicationInitializer.class)
public class ApplicationConfiguration extends WebMvcConfigurerAdapter  {

}