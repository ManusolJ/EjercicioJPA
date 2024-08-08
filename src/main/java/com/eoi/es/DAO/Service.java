package com.eoi.es.DAO;

import java.util.List;

public interface Service {

    public void Create(Object o);

    public Object findObjectByKey(Object key);

    public void Update(Object o);

    public void Delete(Object o);

    public List<?> findAll();
}
