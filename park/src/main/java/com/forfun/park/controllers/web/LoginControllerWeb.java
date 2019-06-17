package com.forfun.park.controllers.web;

import com.forfun.park.payloads.SignUpRequest;
import com.forfun.park.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginControllerWeb {
    @Autowired
    private UserService service;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping
    public String regPost(SignUpRequest signUpRequest) {
        if (service.existsByUsername(signUpRequest.getUsername())) {
            return "reg";
        }
        if (service.existsByEmail(signUpRequest.getEmail())) {
            return "reg";
        }
        service.signUp(signUpRequest);

        return "redirect:/issue";
    }
}
