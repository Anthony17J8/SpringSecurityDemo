package ru.icoltd.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping(path = "/")
    public String showHome(){

        return "home";
    }

    // add request mapping for /leaders
    @GetMapping(path = "/leaders")
    public String showLeaders(){

        return "leaders";
    }

    // add request mapping for /systems
    @GetMapping(path = "/systems")
    public String showSystems(){

        return "systems";
    }
}
