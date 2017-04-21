package net.template.rest.blog;

import lombok.extern.slf4j.Slf4j;
import net.template.data.model.User;
import net.template.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import java.security.Principal;
import java.util.List;

/**
 * Created by prayoon-pc on 4/10/2017.
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserServiceController {

    @Autowired
    private UserService userService;

    public String signin(Principal principal, RedirectAttributes ra) {
        return principal == null ? "users/signin" : "redirect:/";
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUser() {
        log.info("Fetching All User ");
        List<User> users = userService.findAll();
        if (users == null || users.size() == 0) {
            log.info("User not found : {} records" , users.size());
            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        log.info("Fetching User with id " + id);
        User user = (User) userService.findById(id);
        if (user == null) {
            log.info("User with id {} not found" , id);
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/dup/", method = RequestMethod.POST)
    public ResponseEntity<Void> checkDuplicateEmail(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        log.info("Check dupicate with email : {} " , user.getEmail());
        if (userService.isDuplicateEmail(user.getEmail())) {
            log.info("Email {} is duplicate", user.getEmail());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity("true", HttpStatus.OK);
    }
}
