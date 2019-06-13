package com.practice.metric.prometheus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Luo Bao Ding
 * @since 2019/1/31
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "ok";
    }
}
