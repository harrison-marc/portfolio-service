package com.marcharrison;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by marc on 9/22/17.
 */

@SpringBootApplication
public class Application {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Welcome to my living resume!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
