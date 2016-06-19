package be.koencorstjens.springsecurity.testproject.repository;

import be.koencorstjens.springsecurity.testproject.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by koencorstjens on 6/09/15.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String userName);

    List<User> findAll();
}
