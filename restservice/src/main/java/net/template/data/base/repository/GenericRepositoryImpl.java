package net.template.data.base.repository;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Repository
@Transactional
@Getter
@Setter
@Slf4j
public abstract class GenericRepositoryImpl<T> implements GenericRepository<T> {


    @Autowired
    public EntityManager em;

    private Class<T> clazz;

    public GenericRepositoryImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        this.clazz = (Class) pt.getActualTypeArguments()[0];
    }


    @Override
    public T save(T t) {
        em.persist(t);
        return t;
    }

    @Override
    public T update(T t) {
        em.merge(t);
        return t;
    }


    @Override
    public T findOne(long pk) {
        return em.find(clazz, pk);
    }


    @Override
    public List<T> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> rootEntry = cq.from(clazz);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public void deleteAll() {
        findAll().forEach(t -> em.detach(t));
    }


    @Override
    public void delete(long pk) {
        T t = findOne(pk);
        if (t != null) {
            em.detach(t);
        }
    }

    @Override
    public void delete(T t) {
        em.detach(t);
    }

}
