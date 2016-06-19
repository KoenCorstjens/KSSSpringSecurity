package be.koencorstjens.springsecurity.testproject.security;

import org.springframework.stereotype.Component;


@Component("mySecurityService")
public class MySecurityService {

    public boolean hasPermission(String key){
        return true;
    }
}


