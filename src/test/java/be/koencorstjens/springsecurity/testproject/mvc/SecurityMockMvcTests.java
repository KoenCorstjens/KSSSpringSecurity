package be.koencorstjens.springsecurity.testproject.mvc;

import be.koencorstjens.springsecurity.testproject.Application;
import be.koencorstjens.springsecurity.testproject.annotatie.WithCustomMockUser;
import be.koencorstjens.springsecurity.testproject.model.User;
import be.koencorstjens.springsecurity.testproject.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by KCORSTJE on 18/10/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class SecurityMockMvcTests {
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private Filter springSecurityFilterChain;

    private MockMvc mvc;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setup() {

        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithCustomMockUser
    public void koenCanAccessOwnUserInformation() throws Exception {
        MockHttpServletRequestBuilder compose = get("/user/1");
        mvc
                .perform(compose)
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @WithCustomMockUser
    public void koenCanNotAccessKrisUserInformation() throws Exception {
        MockHttpServletRequestBuilder compose = get("/user/2");
        mvc
                .perform(compose)
                .andExpect(status().isForbidden());
    }

    @Test
    @WithCustomMockUser
    public void deleteProject() throws Exception {
        MockHttpServletRequestBuilder compose = post("/project/2/delete").with(csrf());
        mvc
                .perform(compose)
                .andExpect(status().is3xxRedirection());
    }



    @Test
    public void loginKoenUsernamePasswordRolleUser() throws Exception {
        mvc
                .perform(formLogin().user("kcorstjens@example.eu").password("password"))
                .andExpect(authenticated().withRoles("USER"));
    }

    @Test
    public void loginKoenUsernameInvalidPassword() throws Exception {
        mvc
                .perform(formLogin().user("kcorstjens@example.eu").password("invalid"))
                .andExpect(unauthenticated());
    }

    @Test
    public void validUsernamePassword() throws Exception {
        mvc
                .perform(formLogin().user("krobbrecht@example.eu").password("password"))
                .andExpect(authenticated().withRoles("USER","ADMIN"));
    }


}
