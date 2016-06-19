package be.koencorstjens.springsecurity.testproject;

import be.koencorstjens.springsecurity.testproject.repository.UserRepository;
import be.koencorstjens.springsecurity.testproject.model.Project;
import be.koencorstjens.springsecurity.testproject.model.User;
import be.koencorstjens.springsecurity.testproject.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;


    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        // save a couple of projects
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user1 = new User("Koen", "Corstjens", "kcorstjens@example.eu", bCryptPasswordEncoder.encode("password"), false);
        User user2 = new User("Kris", "Robbrecht", "krobbrecht@example.eu", bCryptPasswordEncoder.encode("password"), true);
        userRepository.save(user1);
        userRepository.save(user2);

        projectRepository.save(new Project("Ovam", user1));
        projectRepository.save(new Project("ING", user1));
        projectRepository.save(new Project("Fortis", user1));

        projectRepository.save(new Project("Architectuur", user2));
        projectRepository.save(new Project("Java", user2));
        projectRepository.save(new Project("Net", user2));

    }
}