package com.psdkp.api.unit_working.service.unitWorking;

import com.psdkp.api.unit_working.domain.UnitWorking;
import com.psdkp.api.unit_working.service.BaseService;
import org.springframework.data.domain.Pageable;

public interface UnitWorkingService extends BaseService<Object, UnitWorking, Integer> {

    Object findByTypeUnit (Integer id, Pageable pageable);
}
