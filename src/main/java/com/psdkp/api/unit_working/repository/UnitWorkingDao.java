package com.psdkp.api.unit_working.repository;

import com.psdkp.api.unit_working.domain.UnitWorking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitWorkingDao extends PagingAndSortingRepository<UnitWorking, Integer> {

    @Query(value = "SELECT * FROM unit_working uw WHERE uw.name LIKE %?1% OR uw.code LIKE %?1% OR uw.email LIKE %?1% OR uw.phone LIKE %?1%", nativeQuery = true)
    Page<UnitWorking> findAllByName(String name, Pageable pageable);

    UnitWorking findByCode(String code);
    UnitWorking findByName(String name);
    UnitWorking findByPhone(String phone);
    UnitWorking findByFacsimile(String facsimile);
    UnitWorking findByEmail(String email);

    @Query(value = "select * from unit_working uw where uw.type_unit_id=?1", nativeQuery = true)
    Page<UnitWorking> findByTypeUnit(Integer id, Pageable pageable);

    @Query(value = "select * from unit_working uw where uw.id=?1", nativeQuery = true)
    UnitWorking findId(Integer id);
}
