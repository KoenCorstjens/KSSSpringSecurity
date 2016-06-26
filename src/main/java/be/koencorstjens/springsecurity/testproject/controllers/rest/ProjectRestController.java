package be.koencorstjens.springsecurity.testproject.controllers.rest;

import be.koencorstjens.springsecurity.testproject.model.Project;
import be.koencorstjens.springsecurity.testproject.model.User;
import be.koencorstjens.springsecurity.testproject.service.ProjectService;
import be.koencorstjens.springsecurity.testproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by koencorstjens on 26/06/16.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/rest/project")
public class ProjectRestController {

    @Autowired
    protected ProjectService projectService;

    @RequestMapping(value = "/all")
    public @ResponseBody List<Project> findALL(){
        List<Project> all = projectService.findAll();
        return all;
    }
}
