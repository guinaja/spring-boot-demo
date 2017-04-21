package net.template.data.service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.template.data.base.service.GenericServiceImpl;
import net.template.data.model.UserRole;
import net.template.data.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by prayoon-pc on 4/10/2017.
 */
@Service
@Transactional
@Getter
@Setter
@Slf4j
public class UserRoleServiceImpl extends GenericServiceImpl<UserRole> implements UserRoleService {

    @Autowired
    private UserRoleRepository dao;

    public UserRoleServiceImpl(UserRoleRepository dao) {
        super(dao);
    }


}
