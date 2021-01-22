package com.istic.casanova.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRessource {

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/portail")
    public String client(){
        return ("<h1>Client</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Admin</h1>");
    }

}
