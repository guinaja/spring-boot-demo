package net.template.data.repository;

import lombok.extern.slf4j.Slf4j;
import net.template.data.base.repository.GenericRepository;
import net.template.data.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by prayoon-pc on 3/30/2017.
 */

@Repository
public interface UserRepository extends GenericRepository<User> {

    public User findByEmail(String username);

}
