package com.test.springmvctest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/helloword")
    public String HelloController(){
        System.out.println("hello world");
        return "success";
    }
}
