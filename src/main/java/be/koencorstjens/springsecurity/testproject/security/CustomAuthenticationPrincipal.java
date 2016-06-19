package be.koencorstjens.springsecurity.testproject.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;;

import java.lang.annotation.*;

/**
 * Created by KCORSTJE on 11/10/2015.
 */

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal

public @interface CustomAuthenticationPrincipal {
}
