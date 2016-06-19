package be.koencorstjens.springsecurity.testproject.service.impl;

import be.koencorstjens.springsecurity.testproject.model.User;
import be.koencorstjens.springsecurity.testproject.repository.UserRepository;
import be.koencorstjens.springsecurity.testproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by KCORSTJE on 13/10/2015.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public void save(List<User> users) {
        userRepository.save(users);
    }

    @Override
    public User get(Long id){
        User user = userRepository.findOne(id);
        return user;
    }


    @Override
    public void save(User user){
        userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
