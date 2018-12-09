package ru.icoltd.springsecurity.demo.dao;

import ru.icoltd.springsecurity.demo.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User user);
}
