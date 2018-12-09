package ru.icoltd.springsecurity.demo.dao;

import ru.icoltd.springsecurity.demo.entity.Role;

public interface RoleDao {

    Role findRoleByName(String theRoleName);

}
