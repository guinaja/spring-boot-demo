package net.template.data.repository;

import net.template.data.base.repository.GenericRepository;
import net.template.data.model.UserRole;

import java.util.List;

/**
 * Created by prayoon-pc on 3/30/2017.
 */

public interface UserRoleRepository extends GenericRepository<UserRole> {

    public List<String> getAllRole();

}
