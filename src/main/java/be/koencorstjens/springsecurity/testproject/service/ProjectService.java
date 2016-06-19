package be.koencorstjens.springsecurity.testproject.service;

import be.koencorstjens.springsecurity.testproject.dto.projectDto;
import be.koencorstjens.springsecurity.testproject.model.Project;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by koencorstjens on 29/04/15.
 */
@Service
public interface ProjectService {
    @PreAuthorize("@mySecurityService.hasPermission('special')")
    void doSpecialStuff();

    List<Project> findAll();

    Project find(Long id);

    void delete(Long id);

    projectDto create(projectDto projectDto);

    List<Project> getForCurrentUserBySpEL();

    @PreAuthorize("isAuthenticated()")
    @PostFilter("filterObject.manager.id == principal.id")
    List<Project> getForCurrentUserByPostFilter();



}
