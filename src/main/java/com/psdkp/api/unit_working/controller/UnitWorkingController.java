package com.psdkp.api.unit_working.controller;

import com.psdkp.api.unit_working.domain.Input;
import com.psdkp.api.unit_working.domain.UnitWorking;
import com.psdkp.api.unit_working.service.unitWorking.impl.UnitWorkingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/areas/unitWorking")
public class UnitWorkingController {

    @Autowired
    private UnitWorkingServiceImpl unitWorkingService;

    @GetMapping
    public Object getFindByName(
            @RequestParam(defaultValue = "", required = false) String name,
            @RequestParam(defaultValue = "", required = false) Integer id,
            @RequestParam(defaultValue = "", required = false) Integer typeUnitId,
            @PageableDefault(sort = { "id" }, value = 2000)Pageable pageable
    ) {
        if (id != null) {
            return unitWorkingService.findById(id);
        } else if (typeUnitId != null){
            return unitWorkingService.findByTypeUnit(typeUnitId, pageable);
        } else {
            return unitWorkingService.findAll(name, pageable);
        }
    }

    @PostMapping
    public Object saveUnitWorking(@RequestBody UnitWorking unitWorking) {
        return unitWorkingService.save(unitWorking);
    }

    @PutMapping
    public Object editUnitWorking(@RequestBody UnitWorking unitWorking){
        return unitWorkingService.edit(unitWorking);
    }

    @DeleteMapping(value = "/del")
    public Object removeUnitWorking(@RequestBody Input input){
        return unitWorkingService.del(input.getId());
    }
}
