package com.anastasios.spring.microservices.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class SpringBootMicroservicesApplication extends SpringBootServletInitializer {

    /*
     * Used when running as a JAR file
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMicroservicesApplication.class, args);
    }

    /*
     * Used when running as a WAR file
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootMicroservicesApplication.class);
    }

    /*
     * Configure a default Locale for API services
     */
    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }

    /*
     * Specifies the base name of the properties files. In this case messages.
     * NOTE: This method can be deleted if base name is added in application,properties file. (spring.messages.basename=messages)
     */
    @Bean(name = "messageSource")
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

}
