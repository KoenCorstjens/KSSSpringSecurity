package be.koencorstjens.springsecurity.testproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by koencorstjens on 6/09/15.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String create() {
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start() {
        return "redirect:/project";
    }

}
