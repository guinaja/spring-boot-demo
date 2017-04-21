package net.template.data.repository;

import net.template.data.base.repository.GenericRepository;
import net.template.data.model.User;

/**
 * Created by prayoon-pc on 3/30/2017.
 */

public interface UserRepository  extends GenericRepository<User> {

    public User findByEmail(String username);

}
