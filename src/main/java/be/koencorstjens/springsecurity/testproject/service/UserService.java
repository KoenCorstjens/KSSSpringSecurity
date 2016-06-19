package be.koencorstjens.springsecurity.testproject.service;

import be.koencorstjens.springsecurity.testproject.model.User;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by KCORSTJE on 13/10/2015.
 */
@Service
public interface UserService {

    @PreFilter("filterObject.manager.id == principal.id")
    void save(List<User> users);

    @PostAuthorize("hasRole('ADMIN') or returnObject.id == principal.id")
    User get(Long id);

    @PreAuthorize("hasRole('ADMIN') or returnObject.id == principal.id")
    void save(User user);

    @PostFilter("hasRole('ADMIN') or filterObject.id == principal.id")
    List<User> getAll();


}
