package com.memorynotfound.spring.security.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private InMemoryUserDetailsManager userManager;

    @GetMapping("/")
    public String greeting() {
        return "Spring Security In-memory Authentication Example";
    }

}
