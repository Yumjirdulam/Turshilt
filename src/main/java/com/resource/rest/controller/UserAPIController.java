package com.resource.rest.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAPIController {

	@RequestMapping(method = RequestMethod.GET,value = "/api/me")
    public Principal me(Principal principal) {
        return principal;
    }
	
}
