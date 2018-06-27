package com.psdkp.api.unit_working.service.unitWorking;

import com.psdkp.api.unit_working.domain.MappingUnitWorking;
import com.psdkp.api.unit_working.service.BaseService;
import org.springframework.data.domain.Pageable;

public interface MappingUnitWorkingService extends BaseService<Object, MappingUnitWorking, Integer> {

    Object  findByParrent(Integer id, Pageable pageable);
    Object  findByUpt(Integer id, Pageable pageable);
}
