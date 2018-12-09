package ru.icoltd.springsecurity.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.icoltd.springsecurity.demo.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findByUserName(String userName) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // retrieve user from database using username
        Query<User> query = currentSession.createQuery("from User where userName=:uName", User.class);
        query.setParameter("uName", userName);
        User theUser = null;
        try {
            theUser = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return theUser;
    }

    @Override
    public void save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
    }
}
