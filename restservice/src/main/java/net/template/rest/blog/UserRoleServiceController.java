package net.template.rest.blog;

import lombok.extern.slf4j.Slf4j;
import net.template.data.base.service.GenericService;
import net.template.data.model.User;
import net.template.data.model.UserRole;
import net.template.data.service.UserRoleService;
import net.template.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

/**
 * Created by prayoon-pc on 4/10/2017.
 */
@Slf4j
@Controller
@RequestMapping("userrole")
public class UserRoleServiceController extends GenericController<UserRole>{

    public UserRoleServiceController(GenericService<UserRole> service) {
        super(service);
    }
    @Autowired
    private UserRoleService userService;

}
