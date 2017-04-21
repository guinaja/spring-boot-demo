package net.template.data.service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.template.data.base.service.GenericServiceImpl;
import net.template.data.model.User;
import net.template.data.repository.UserRepository;
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
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {

    @Autowired
    private UserRepository dao;

    public UserServiceImpl(UserRepository dao) {
        super(dao);
    }


    @Override
    public boolean isDuplicateEmail(String email) {
        return getDao().findByEmail(email) != null;
    }


}
