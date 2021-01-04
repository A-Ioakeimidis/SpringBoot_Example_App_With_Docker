package com.anastasios.spring.microservices.app.controller;

import com.anastasios.spring.microservices.app.beans.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello-world")
    public String sayHeloWolrd() {
        return "Hello world";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean sayHelloFromBean() {
        return new HelloWorldBean("Hello from the bean");
    }

    @GetMapping(value = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        return messageSource.getMessage("message.good.morning", null, LocaleContextHolder.getLocale());
    }

}
