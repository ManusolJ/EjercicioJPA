package com.eoi.es.service;

import com.eoi.es.entity.Cliente;

public interface Service {

    public void Create(Object o);

    public Object findObjectByKey(Object key);

    public void Update(Object o);

    public void Delete(Object o);

}
