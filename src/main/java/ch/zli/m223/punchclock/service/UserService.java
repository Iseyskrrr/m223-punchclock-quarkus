package ch.zli.m223.punchclock.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.punchclock.domain.User;

@ApplicationScoped
public class UserService {
    @Inject
    EntityManager entityManager;
    
    @Transactional 
    public User add(User user) {
        entityManager.persist(user);
        return user;
    }

    public List<User> list() {
        var query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    public User getById(long id) {
        var query = entityManager.createQuery("FROM User WHERE id=:id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
