package com.psdkp.api.unit_working.repository;

import com.psdkp.api.unit_working.domain.Infrastructure;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InfrastructureDao extends JpaRepository<Infrastructure, Integer> {

    @Query(value = "select * from infrastructure p where p.name like %?1% ", nativeQuery = true)
    Page<Infrastructure> findAllByName(String name, Pageable pageable);

    Infrastructure findByName(String name);

    @Query(value = "select * from infrastructure p where p.id=?1", nativeQuery = true)
    Infrastructure findId(Integer id);
}
