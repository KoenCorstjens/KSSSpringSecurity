package be.koencorstjens.springsecurity.testproject.service;

import be.koencorstjens.springsecurity.testproject.Application;
import be.koencorstjens.springsecurity.testproject.annotatie.WithCustomMockUser;
import be.koencorstjens.springsecurity.testproject.model.User;
import be.koencorstjens.springsecurity.testproject.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.security.test.context.support.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Koen on 16/10/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Before
    public void setup(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user1 = new User("Koen", "Corstjens", "kcorstjens@example.eu", bCryptPasswordEncoder.encode("password"), false);
        User user2 = new User("Kris", "Robbrecht", "krobbrecht@example.eu", bCryptPasswordEncoder.encode("password"), true);
        userRepository.save(user1);
        userRepository.save(user2);
    }

    @Test(expected = AuthenticationCredentialsNotFoundException.class)
    public void getAllUnauthenticated() {
        List<User> all = userService.getAll();
    }

    @Test
    @WithMockUser
    public void getAll() {
        List<User> all = userService.getAll();
        all.size();
    }

    @Test
    @WithMockUser()
    public void getAllForUser() {
        List<User> all = userService.getAll();
        Assert.assertEquals(0, all.size());
    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void getAllForAdmin() {
        List<User> all = userService.getAll();
        Assert.assertEquals(2, all.size());
    }

    @Test
    @WithCustomMockUser
    public void getAllForUserKoen() {
        List<User> all = userService.getAll();
        Assert.assertEquals(1, all.size());
    }


}
