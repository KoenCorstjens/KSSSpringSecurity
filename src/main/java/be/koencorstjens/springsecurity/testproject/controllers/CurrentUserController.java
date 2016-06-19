package be.koencorstjens.springsecurity.testproject.controllers;

import be.koencorstjens.springsecurity.testproject.model.User;
import be.koencorstjens.springsecurity.testproject.security.CustomAuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Koen on 14/10/2015.
 */
@Controller
@RequestMapping(value = "/user")
public class CurrentUserController {

    @ModelAttribute("view")
    private String view(){
        return "user";
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String getUserDetails(Model model, @CustomAuthenticationPrincipal User currentUser ){
        model.addAttribute("user",currentUser);
        return "userdetails";
    }
}
