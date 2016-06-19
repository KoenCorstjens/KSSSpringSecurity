package be.koencorstjens.springsecurity.testproject.controllers;

import be.koencorstjens.springsecurity.testproject.model.User;
import be.koencorstjens.springsecurity.testproject.dto.projectDto;
import be.koencorstjens.springsecurity.testproject.model.Project;
import be.koencorstjens.springsecurity.testproject.service.UserService;
import be.koencorstjens.springsecurity.testproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by koencorstjens on 29/04/15.
 */
@Controller
@RequestMapping(value = "/project")
public class ProjectController {
    @ModelAttribute("view")
    private String view(){
        return "project";
    }

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getProjects(Model model) {
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);
        return "projects";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("project", new projectDto());
        return "project_create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPost(@ModelAttribute projectDto project, Model model) {
        project = projectService.create(project);
        Long id = project.getId();
        return "redirect:/project/" + id;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getProjects(@PathVariable Long id, Model model) {
        Project project = projectService.find(id);
        model.addAttribute("project", project);
        return "project";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable Long id) {
        projectService.delete(id);
        return "redirect:/project";
    }


}
