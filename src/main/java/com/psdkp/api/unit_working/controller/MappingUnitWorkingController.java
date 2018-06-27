package com.psdkp.api.unit_working.controller;

import com.psdkp.api.unit_working.domain.Input;
import com.psdkp.api.unit_working.domain.MappingUnitWorking;
import com.psdkp.api.unit_working.service.unitWorking.impl.MappingUnitWorkingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/areas/mappingUnit")
public class MappingUnitWorkingController {

    @Autowired
    private MappingUnitWorkingServiceImpl mappingUnitWorkingService;

    @GetMapping
    public Object getFindByName(
            @RequestParam(defaultValue = "", required = false) String name,
            @RequestParam(defaultValue = "", required = false) Integer id,
            @RequestParam(defaultValue = "", required = false) Integer parrentId,
            @RequestParam(defaultValue = "", required = false) Integer uptId,
            @PageableDefault(sort = { "id" }, value = 1000) Pageable pageable
    ) {
        if (id != null) {
            return mappingUnitWorkingService.findById(id);
        } else if (parrentId!=null) {
            return mappingUnitWorkingService.findByParrent(parrentId, pageable);
        } else if (uptId!=null){
            return mappingUnitWorkingService.findByUpt(uptId, pageable);
        }else {
            return mappingUnitWorkingService.findAll(name, pageable);
        }
    }

    @PostMapping
    public Object saveUnitWorking(@RequestBody MappingUnitWorking unitWorking) {
        System.out.println(unitWorking.toString());
        return mappingUnitWorkingService.save(unitWorking);
    }

    @PutMapping
    public Object editUnitWorking(@RequestBody MappingUnitWorking unitWorking){
        return mappingUnitWorkingService.edit(unitWorking);
    }

    @DeleteMapping(value = "/del")
    public Object removeUnitWorking(@RequestBody Input input){
        System.out.println(input.getId());
        return mappingUnitWorkingService.del(input.getId());
    }
}
