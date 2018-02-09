package com.resource.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {



    @RequestMapping("/admin/secure")
    public String superSecureMessage(){
        return "Super Secured admin";
    }
}

