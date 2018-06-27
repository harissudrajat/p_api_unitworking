package com.psdkp.api.unit_working.repository;

import com.psdkp.api.unit_working.domain.MappingUnitWorking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingUnitWorkingDao extends JpaRepository<MappingUnitWorking, Integer> {

    @Query(value = "select * from mapping_unit_working", nativeQuery = true)
    Page<MappingUnitWorking> findAllBy(Pageable pageable);

    @Query(value = "select * from mapping_unit_working tu where tu.id=?1", nativeQuery = true)
    MappingUnitWorking findId(Integer id);

    @Query(value = "select * from mapping_unit_working a where a.upt_id=?1", nativeQuery = true)
    Page<MappingUnitWorking> findByUptId(Integer id, Pageable pageable);

    @Query(value = "select * from mapping_unit_working a where a.parrent_id=?1", nativeQuery = true)
    Page<MappingUnitWorking> findAllByType(Integer id, Pageable pageable);

}
