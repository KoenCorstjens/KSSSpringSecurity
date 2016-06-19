package be.koencorstjens.springsecurity.testproject.annotatie;

import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.*;

/**
 * Created by Koen on 16/10/2015.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@WithSecurityContext(factory = WithCustomUserSecurityContextFactory.class)
public @interface WithCustomMockUser {

    String email() default "kcorstjens@example.eu";

    long id() default 1L;

    String firstName() default "Koen";

    String lastName() default "Corstjens";

    boolean manager() default false;
}
