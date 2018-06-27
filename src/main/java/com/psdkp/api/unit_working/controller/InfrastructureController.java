package com.psdkp.api.unit_working.controller;

import com.psdkp.api.unit_working.domain.Infrastructure;
import com.psdkp.api.unit_working.domain.Input;
import com.psdkp.api.unit_working.service.unitWorking.impl.InfrastructureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/areas/infrastructure")
public class InfrastructureController {

    @Autowired
    private InfrastructureServiceImpl infrastructureServiceImpl;

    @GetMapping
    public Object getFindByName(
            @RequestParam(defaultValue = "", required = false) String type,
            @RequestParam(defaultValue = "", required = false) Integer id,
            @PageableDefault(sort = { "id" }, value = 20)Pageable pageable
    ) {
        if (id != null) {
            return infrastructureServiceImpl.findById(id);
        } else {
            return infrastructureServiceImpl.findAll(type, pageable);
        }
    }

    @PostMapping
    public Object saveTypeUnit(@RequestBody Infrastructure infrastructure){
        return infrastructureServiceImpl.save(infrastructure);
    }

    @PutMapping
    public Object editTypeUnit(@RequestBody Infrastructure infrastructure){
        return infrastructureServiceImpl.edit(infrastructure);
    }

    @DeleteMapping(value = "/del")
    public Object removeTypeUnit(@RequestBody Input input){
        return infrastructureServiceImpl.del(input.getId());
    }
}
