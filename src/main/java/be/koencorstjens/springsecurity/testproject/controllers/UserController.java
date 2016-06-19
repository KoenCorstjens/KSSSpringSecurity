package be.koencorstjens.springsecurity.testproject.controllers;

import be.koencorstjens.springsecurity.testproject.model.User;
import be.koencorstjens.springsecurity.testproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Koen on 14/10/2015.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute("view")
    private String view(){
        return "users";
    }

    @RequestMapping()
    public String getAll(Model model){
        List<User> all = userService.getAll();
        model.addAttribute("users",all);
        return "users";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String save(@PathVariable Long id, Model model){
        User user = userService.get(id);
        model.addAttribute("user",user);
        return "userdetails";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(User user){
        userService.save(user);
        return "redirect:/user/"+user.getId();
    }

}
