package com.identity.keycloak.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class UserController {

    @GetMapping(path = "/")
    public String index() {
        return "welcome";
    }
    @GetMapping(path = "/homepage")
    public String home() {
        return "home";
    }


    @GetMapping(path = "/admin")
    public String admin(Principal principal, Model model) {
        return "admin";
    }
    @GetMapping(path = "/user")
    public String user(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "user";
    }
    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return  "/";
    }
}
