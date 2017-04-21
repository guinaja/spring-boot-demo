package net.template.data.model;

import lombok.Getter;
import lombok.Setter;
import net.template.data.base.model.GenericModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Prayoon.su <prayoonsuntronktit@gmail.com>
 */
@Entity
@Table(name = "user_role")
@Getter
@Setter
public class UserRole extends GenericModel {
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";

    public static List<String> roles;

    static {
        roles = new ArrayList<String>();
        roles.add(ROLE_ADMIN);
        roles.add(ROLE_USER);
    }


    private long userId;
    private String userRole;

    public UserRole() {
    }

    public UserRole(long userId, String userRole) {
        this.userId = userId;
        this.userRole = userRole;
    }
}
