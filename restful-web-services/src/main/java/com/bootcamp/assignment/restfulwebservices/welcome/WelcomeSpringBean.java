package com.bootcamp.assignment.restfulwebservices.welcome;

public class WelcomeSpringBean {
    private String message;

    public WelcomeSpringBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("Welcome to spring [message=%s]", message);
    }
}
