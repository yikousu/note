package com.hac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hac
 * @date 2025/3/20 11:21
 */
@RequestMapping(value = "/api")
@RestController
public class TestController {
    @GetMapping(value = "/test")
    public String test() {
        return "hello";
    }
}
