package com.psdkp.api.unit_working.service;

import org.springframework.data.domain.Pageable;

public interface BaseService<T1,T2,T3> {

    T1 findAll(String name, Pageable pageable);
    T1 save(T2 t2);
    T1 edit(T2 t2);
    T1 del(T3 id);
    T1 findById(T3 id);
}