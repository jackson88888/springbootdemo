package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWprldController {

    @RequestMapping("info")
    public String info(){
        return "helloWorld";
    }
}
