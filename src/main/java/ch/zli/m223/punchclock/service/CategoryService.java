package ch.zli.m223.punchclock.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.punchclock.domain.Category;

@ApplicationScoped
public class CategoryService {
    @Inject
    EntityManager entityManager;
    
    @Transactional 
    public Category add(Category category) {
        entityManager.persist(category);
        return category;
    }

    public List<Category> list() {
        var query = entityManager.createQuery("FROM Category", Category.class);
        return query.getResultList();
    }
}   