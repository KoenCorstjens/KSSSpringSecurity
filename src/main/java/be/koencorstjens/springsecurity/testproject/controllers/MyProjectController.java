package be.koencorstjens.springsecurity.testproject.controllers;

import be.koencorstjens.springsecurity.testproject.model.Project;
import be.koencorstjens.springsecurity.testproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by koencorstjens on 29/04/15.
 */
@Controller
@RequestMapping(value = "/project")
public class MyProjectController {
    @ModelAttribute("view")
    private String view(){
        return "my_project";
    }

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/my",method = RequestMethod.GET)
    public String getCurrentUsersProjects(Model model) {
        List<Project> projects = projectService.getForCurrentUserBySpEL();
        /*List<Project> projects = projectService.getForCurrentUserByPostFilter();*/
        model.addAttribute("projects", projects);
        return "projects_current_user";
    }


}
