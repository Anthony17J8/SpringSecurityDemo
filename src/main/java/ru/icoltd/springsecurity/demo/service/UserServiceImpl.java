package ru.icoltd.springsecurity.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.icoltd.springsecurity.demo.dao.RoleDao;
import ru.icoltd.springsecurity.demo.dao.UserDao;
import ru.icoltd.springsecurity.demo.entity.Role;
import ru.icoltd.springsecurity.demo.entity.User;
import ru.icoltd.springsecurity.demo.user.CrmUser;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    // need to inject user dao
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public User findByUserName(String userName) {

        // check the database if the user already exists
        return userDao.findByUserName(userName);
    }

    @Transactional
    @Override
    public void save(CrmUser crmUser) {
        User user = new User();
        // assign user details to the user object
        user.setUserName(crmUser.getUserName());
        user.setFirstName(crmUser.getFirstName());
        user.setLastName(crmUser.getLastName());
        user.setEmail(crmUser.getEmail());
        user.setPassword(passwordEncoder.encode(crmUser.getPassword()));

        // give user default role of "employee"
        user.setRoles(Collections.singletonList(roleDao.findRoleByName("ROLE_EMPLOYEE")));

        // save user in the database
        userDao.save(user);

    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
