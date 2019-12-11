package com.test.springmvctest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/helloword")
    public String HelloController(){
        System.out.println("hello world");
//        经过视图解析器的prefix前缀+返回值+suffix后缀转发到形视图，/WEB-INF/view/+success+.jsp
        return "success";
    }
}
