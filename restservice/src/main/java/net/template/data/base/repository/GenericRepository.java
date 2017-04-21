package net.template.data.base.repository;


import java.util.List;

public interface GenericRepository<T> {

    public T save(T newStance);

    public T update(T newStance);

    public T findOne(long pk);

    public List<T> findAll();

    public long count();

    public void deleteAll();

    public void delete(long id);

    public void delete(T newStance);

}
