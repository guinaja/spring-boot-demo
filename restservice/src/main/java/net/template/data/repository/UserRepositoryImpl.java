package net.template.data.repository;

import lombok.extern.slf4j.Slf4j;
import net.template.data.base.repository.GenericRepositoryImpl;
import net.template.data.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by prayoon-pc on 4/10/2017.
 */
@Repository
@Slf4j
public class UserRepositoryImpl extends GenericRepositoryImpl<User> implements UserRepository {

    @Override
    public User findByEmail(String email) {
        final String complexSql = "SELECT * FROM USERS WHERE EMAIL = :email";
        Query query = getEm().createNativeQuery(complexSql, User.class);
        query.setParameter("email", email);
        List<User> results = query.getResultList();
        if (results != null && results.size() > 0) {
            return results.get(0);
        }
        return null;
    }

}
