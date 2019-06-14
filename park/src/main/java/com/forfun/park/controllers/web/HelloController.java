package com.forfun.park.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String hello() {
        return "search";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage(){
        return "redirect:/issue/search";
    }
}
