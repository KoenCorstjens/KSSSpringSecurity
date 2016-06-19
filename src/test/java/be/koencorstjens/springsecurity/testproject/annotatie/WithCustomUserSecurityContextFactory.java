package be.koencorstjens.springsecurity.testproject.annotatie;

import be.koencorstjens.springsecurity.testproject.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Koen on 16/10/2015.
 */
public class WithCustomUserSecurityContextFactory implements WithSecurityContextFactory<WithCustomMockUser> {

    public SecurityContext createSecurityContext(WithCustomMockUser customUser) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();

        User principal = new User(customUser.id(),customUser.firstName(),customUser.lastName(),customUser.email(),"",customUser.manager());
        principal.setId(customUser.id());
        Authentication auth =
                new UsernamePasswordAuthenticationToken(principal, "password", AuthorityUtils.createAuthorityList("ROLE_USER"));
        context.setAuthentication(auth);
        return context;
    }
}
