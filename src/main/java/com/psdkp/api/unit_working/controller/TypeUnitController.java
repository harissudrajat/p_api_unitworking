package com.psdkp.api.unit_working.controller;

import com.psdkp.api.unit_working.domain.Input;
import com.psdkp.api.unit_working.domain.TypeUnit;
import com.psdkp.api.unit_working.service.unitWorking.impl.TypeUnitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/areas/typeUnit")
public class TypeUnitController {

    @Autowired
    private TypeUnitServiceImpl typeUnitService;

    @GetMapping
    public Object getFindByName(
            @RequestParam(defaultValue = "", required = false) String type,
            @RequestParam(defaultValue = "", required = false) Integer id,
            @PageableDefault(sort = { "id" }, value = 5)Pageable pageable
    ) {
        if (id != null) {
            return typeUnitService.findById(id);
        } else {
            return typeUnitService.findAll(type, pageable);
        }
    }

    @PostMapping
    public Object saveTypeUnit(@RequestBody TypeUnit typeUnit){
        return typeUnitService.save(typeUnit);
    }

    @PutMapping
    public Object editTypeUnit(@RequestBody TypeUnit typeUnit){
        return typeUnitService.edit(typeUnit);
    }

    @DeleteMapping(value = "/del")
    public Object removeTypeUnit(@RequestBody Input input){
        return typeUnitService.del(input.getId());
    }
}
