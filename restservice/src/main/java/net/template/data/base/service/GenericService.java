package net.template.data.base.service;

import java.util.List;

/**
 * Created by prayoon.su on 4/10/2017.
 */
public interface GenericService<T> {

    void save(T entity);

    void update(T entity);

    void remove(T entity);

    void remove(long pk);

    T findById(long pk);

    List<T> findAll();
}
