package com.psdkp.api.unit_working.repository;

import com.psdkp.api.unit_working.domain.Facilities;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FacilitiesDao extends JpaRepository<Facilities, Integer> {

    @Query(value = "select * from facilities p where p.name like %?1% ", nativeQuery = true)
    Page<Facilities> findAllByName(String name, Pageable pageable);

    Facilities findByName(String name);

    @Query(value = "select * from facilities p where p.id=?1", nativeQuery = true)
    Facilities findId(Integer id);
}
