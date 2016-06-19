package be.koencorstjens.springsecurity.testproject.service.impl;

import be.koencorstjens.springsecurity.testproject.repository.ProjectRepository;
import be.koencorstjens.springsecurity.testproject.service.ProjectService;
import be.koencorstjens.springsecurity.testproject.dto.projectDto;
import be.koencorstjens.springsecurity.testproject.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by koencorstjens on 29/04/15.
 */

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void doSpecialStuff() {

    }

    @Override
    public List<Project> findAll() {
        List<Project> projects = projectRepository.findAll();
        return projects;
    }

    @Override
    public Project find(Long id) {
        Project project = projectRepository.findOne(id);
        return project;
    }

    @Override
    public void delete(Long id) {
        projectRepository.delete(id);
    }

    @Override
    public projectDto create(projectDto projectDto) {
        projectDto.setId(2l);
        return projectDto;
    }

    @Override
    public List<Project> getForCurrentUserBySpEL() {
        return projectRepository.findForCurrentUser();
    }

    @Override
    public List<Project> getForCurrentUserByPostFilter() {
        List<Project> projects = projectRepository.findAll();
        return projects;
    }



}
