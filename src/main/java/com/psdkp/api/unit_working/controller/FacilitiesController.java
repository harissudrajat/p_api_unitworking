package com.psdkp.api.unit_working.controller;

import com.psdkp.api.unit_working.domain.Facilities;
import com.psdkp.api.unit_working.domain.Input;
import com.psdkp.api.unit_working.service.unitWorking.impl.FacilitiesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/areas/facilities")
public class FacilitiesController {

    @Autowired
    private FacilitiesServiceImpl facilitiesServiceImpl;

    @GetMapping
    public Object getFindByName(
            @RequestParam(defaultValue = "", required = false) String type,
            @RequestParam(defaultValue = "", required = false) Integer id,
            @PageableDefault(sort = { "id" }, value = 20)Pageable pageable
    ) {
        if (id != null) {
            return facilitiesServiceImpl.findById(id);
        } else {
            return facilitiesServiceImpl.findAll(type, pageable);
        }
    }

    @PostMapping
    public Object saveTypeUnit(@RequestBody Facilities facilities){
        return facilitiesServiceImpl.save(facilities);
    }

    @PutMapping
    public Object editTypeUnit(@RequestBody Facilities facilities){
        return facilitiesServiceImpl.edit(facilities);
    }

    @DeleteMapping(value = "/del")
    public Object removeTypeUnit(@RequestBody Input input){
        return facilitiesServiceImpl.del(input.getId());
    }
}
