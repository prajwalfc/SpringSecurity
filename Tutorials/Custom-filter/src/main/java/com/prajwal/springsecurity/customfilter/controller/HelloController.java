package com.prajwal.springsecurity.customfilter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String getMapping(){
        return "gdjbfjbd";
    }

    @GetMapping
    public String getRoot(){
        return "root";
    }
}
