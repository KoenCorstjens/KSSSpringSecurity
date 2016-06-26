package be.koencorstjens.springsecurity.testproject.controllers;

import be.koencorstjens.springsecurity.testproject.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by koencorstjens on 26/06/16.
 */
@Controller
@RequestMapping(value = "/singlepage")
public class SinglePageController {
    @RequestMapping()
    public String getAll(Model model){

        return "singlepage";
    }
}
