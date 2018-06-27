package com.psdkp.api.unit_working.repository;

import com.psdkp.api.unit_working.domain.TypeUnit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeUnitDao extends PagingAndSortingRepository<TypeUnit, Integer> {

    @Query(value = "select * from type_unit tu where tu.type like %?1%", nativeQuery = true)
    Page<TypeUnit> findAllByType(String type, Pageable pageable);

    TypeUnit findByType(String type);

    @Query(value = "select * from type_unit tu where tu.id=?1", nativeQuery = true)
    TypeUnit findId(Integer id);
}
