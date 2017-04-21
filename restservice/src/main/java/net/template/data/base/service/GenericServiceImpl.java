package net.template.data.base.service;

import lombok.extern.slf4j.Slf4j;
import net.template.data.base.repository.GenericRepository;

import java.util.List;

/**
 * Created by prayoon.su on 4/10/2017.
 */
@Slf4j
public abstract class GenericServiceImpl<T> implements GenericService<T> {

    private GenericRepository<T> dao;

    public GenericServiceImpl(GenericRepository<T> dao) {
        this.dao = dao;
    }

    @Override
    public void save(T entity) {
        dao.save(entity);
    }

    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    @Override
    public void remove(T entity) {
        dao.delete(entity);
    }

    @Override
    public void remove(long pk) {
        dao.delete(pk);
    }

    @Override
    public T findById(long pk) {
        return dao.findOne(pk);
    }

    @Override
    public List<T> findAll() {
        return dao.findAll();
    }
}
