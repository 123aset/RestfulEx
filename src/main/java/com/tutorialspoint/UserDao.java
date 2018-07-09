package com.tutorialspoint;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserDao {
    public EntityManager em = Persistence.createEntityManagerFactory("aset").createEntityManager();
    Logger log = Logger.getLogger(UserDao.class.getName());

    public User add(User user) {
        em.getTransaction().begin();
        User userFromDB = em.merge(user);
        log.info("Add user: " + userFromDB);
        em.getTransaction().commit();
        return userFromDB;
    }

    public List<User> delete(long id) {
        em.getTransaction().begin();
        log.info("Delete user: " + get(id));
        em.remove(get(id));
        em.getTransaction().commit();
        return getAll();
    }

    public User get(long id) {
        return em.find(User.class, id);
    }

    public User update(
            long id,
            int active,
            String email,
            String last_name,
            String name,
            String password
    ) {
        User user = get(id);
        user.setActive(active);
        user.setEmail(email);
        user.setLast_name(last_name);
        user.setName(name);
        user.setPassword(password);
        em.getTransaction().begin();
        em.persist(user);
        log.info("Update user:" + user);
        em.getTransaction().commit();
        return user;
    }

    public List<User> getAll() {
        Query namedQuery = em.createQuery("FROM User");
        log.info("Get all users:" + namedQuery.getResultList());
        return namedQuery.getResultList();
    }
}