package com.anastasios.spring.microservices.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class InitialController {

    @RequestMapping("/hi")
    public @ResponseBody String sayHi() {
        return "Hello Docker World!";
    }

    @RequestMapping("/hi/{name}")
    public String sayHiWithName(ModelAndView model, @PathVariable String name) {
        model.addObject("name", name);
        return "hello";
    }
}
