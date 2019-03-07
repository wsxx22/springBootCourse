package com.example.springbootcourse.controllers;

import com.example.springbootcourse.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {

    @RequestMapping("/hello")
    public String hello () {
        return "hello";
    }

    public void test () {
        User user = new User();

    }


}
