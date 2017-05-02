package net.template.rest.blog;

import lombok.extern.slf4j.Slf4j;
import net.template.data.base.service.GenericService;
import net.template.data.model.UserRole;
import net.template.data.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by prayoon-pc on 4/10/2017.
 */
@Slf4j
@Controller
@RequestMapping("userrole")
public class UserRoleServiceController extends GenericController<UserRole> {

    @Autowired
    private UserRoleService userService;

    public UserRoleServiceController(GenericService<UserRole> service) {
        super(service);
    }

}
