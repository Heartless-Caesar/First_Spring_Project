package com.caesar.FirstSpringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping("/")
    public String HelloWord() {
        return "Testing a get method in Java TESTING";
    }
}
