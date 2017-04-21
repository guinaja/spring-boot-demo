package net.template.data.service;


import net.template.data.base.service.GenericService;
import net.template.data.model.User;

public interface UserService extends GenericService<User> {

    public boolean isDuplicateEmail(String email);

}
