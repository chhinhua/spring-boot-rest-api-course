package com.chhinhua.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chhin_Hua - 17/03
 **/

@RestController
public class HelloController {


    @GetMapping("/hello-world")
    public String helloController() {
        return "Hello world";
    }
}
