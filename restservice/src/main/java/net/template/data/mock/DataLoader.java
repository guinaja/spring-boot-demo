package net.template.data.mock;

import lombok.extern.slf4j.Slf4j;
import net.template.data.model.User;
import net.template.data.model.UserRole;
import net.template.data.repository.UserRepository;
import net.template.data.repository.UserRoleRepository;
import net.template.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Slf4j
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;


    @Override
    public void run(String... arg0) throws Exception {
        log.info("Start mocking data & test");
        AtomicLong counter = new AtomicLong();
        List<User> users = new ArrayList<User>();
        users.add(new User("sam@abc.com", "Sam", "Sam"));
        users.add(new User("tomy@abc.com", "Tomy", "Tomy"));
        users.add(new User("kelly@abc.com", "Kelly", "Kelly"));


        log.info("Loading test data...");
        users.forEach(user -> userRepository.save(user));
        log.info("Test data loaded...");

        log.info("Query test data...");
        log.info("Result : " + (userService.isDuplicateEmail("kelly@abc.com") ? "true" : "false"));
        log.info("Test data Query...");

        log.info("Fetch test data...");
        log.info("Result : " + userRepository.findOne(1L).toString());
        log.info("Test data fetched...");


        log.info("Loading test data...");
        userRoleRepository.save(new UserRole(userRepository.findOne(1L).getId(), UserRole.ROLE_USER));
        userRoleRepository.save(new UserRole(userRepository.findOne(1L).getId(), UserRole.ROLE_ADMIN));

        userRoleRepository.save(new UserRole(userRepository.findOne(2L).getId(), UserRole.ROLE_USER));
        log.info("Test data loaded...");

        log.info("Count test data...");
        log.info("Result : " + userRepository.count());
        log.info("Test data Count...");
    }
}