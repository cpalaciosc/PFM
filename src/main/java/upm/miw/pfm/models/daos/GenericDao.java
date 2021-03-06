package upm.miw.pfm.models.daos;

import java.util.List;

public interface GenericDao<T, ID> {

    public void create(T entity);

    public T read(ID id);

    public void update(T entity);

    public boolean deleteById(ID id);

    public List<T> findAll();
    
    public Boolean exists(T entity);
    
    public void query(String hql);
    
    public void deleteAll();
    
}

