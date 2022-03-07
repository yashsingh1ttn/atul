package com.bootcamp.assignment.restfulwebservices.welcome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeSpringController {

    @GetMapping(path = "/welcome-spring")
    public String welcomeSpring(){
        return "Welcome to Spring";
    }

    @GetMapping(path = "/welcome-spring-bean")
    public WelcomeSpringBean welcomeSpringBean(){
        return new WelcomeSpringBean("Welcome to Spring");
    }
}
