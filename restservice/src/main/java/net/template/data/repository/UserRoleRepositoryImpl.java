package net.template.data.repository;

import lombok.extern.slf4j.Slf4j;
import net.template.data.base.repository.GenericRepositoryImpl;
import net.template.data.model.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

import static net.template.data.model.UserRole.roles;

/**
 * Created by prayoon-pc on 4/10/2017.
 */
@Repository
@Slf4j
public class UserRoleRepositoryImpl extends GenericRepositoryImpl<UserRole> implements UserRoleRepository {

    @Override
    public List<String> getAllRole() {
        return UserRole.roles;
    }

}
