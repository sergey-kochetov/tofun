package com.forfun.park.controllers.web;

import com.forfun.park.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class UserModel {

    @ModelAttribute("user")
    public User setUserToModel() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getName().equals("anonymousUser")) {
            return new User();
        }
        return (User) authentication.getPrincipal();
    }

}
