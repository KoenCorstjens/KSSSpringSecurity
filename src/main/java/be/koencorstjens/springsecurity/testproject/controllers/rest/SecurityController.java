package be.koencorstjens.springsecurity.testproject.controllers.rest;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by koencorstjens on 26/06/16.
 */
@RestController
public class SecurityController {



    @RequestMapping("/csrf")
    public CsrfToken getCsrf(CsrfToken token){
        return token;
    }

}
