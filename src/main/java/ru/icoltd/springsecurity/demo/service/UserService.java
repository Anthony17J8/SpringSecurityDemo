package ru.icoltd.springsecurity.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.icoltd.springsecurity.demo.entity.User;
import ru.icoltd.springsecurity.demo.user.CrmUser;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);
}
