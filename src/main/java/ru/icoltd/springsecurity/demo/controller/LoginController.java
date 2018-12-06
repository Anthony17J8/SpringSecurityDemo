package ru.icoltd.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(path = "/showMyLoginPage")
    public String showMyLoginPage() {

//  old version: return "plain-login";
        return "fancy-login";
    }

    // add request mapping for /access-denied
    @GetMapping(path = "/access-denied")
    public String showAccessDenied() {

        return "access-denied";
    }
}
