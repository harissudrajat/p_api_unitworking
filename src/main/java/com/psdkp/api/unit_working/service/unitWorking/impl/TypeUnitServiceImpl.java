package com.psdkp.api.unit_working.service.unitWorking.impl;

import com.psdkp.api.unit_working.domain.TypeUnit;
import com.psdkp.api.unit_working.repository.TypeUnitDao;
import com.psdkp.api.unit_working.service.unitWorking.TypeUnitService;
import com.psdkp.api.unit_working.util.ResponMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TypeUnitServiceImpl implements TypeUnitService {

    @Autowired
    private TypeUnitDao typeUnitDao;

    @Autowired
    private ResponMessage responMessage;

    @Override
    public Object findAll(String type, Pageable pageable) {
        return responMessage.SUCCESS_GET(typeUnitDao.findAllByType(type, pageable));
    }

    @Override
    public Object save(TypeUnit typeUnit) {
        if (typeUnit.getType().equals("")) {
            return responMessage.BAD_REUQEST();
        } else {
            TypeUnit t = typeUnitDao.findByType(typeUnit.getType());
            if (t != null) {
                return responMessage.DUPLICATE("TYPE");
            } else {
                typeUnitDao.save(typeUnit);
                return responMessage.SUCCESS_PROCESS_DATA();
            }
        }
    }

    @Override
    public Object edit(TypeUnit typeUnit) {
        if (typeUnit.getId() == null || typeUnit.getType().equals("")) {
            return responMessage.BAD_REUQEST();
        } else {
            TypeUnit t = typeUnitDao.findId(typeUnit.getId());
            if (t == null){
                return responMessage.NOT_FOUND("ID");
            } else {
                TypeUnit t2 = typeUnitDao.findByType(typeUnit.getType());
                if (t2 != null){
                    return responMessage.DUPLICATE("TYPE");
                } else {
                    typeUnitDao.save(typeUnit);
                    return responMessage.SUCCESS_PROCESS_DATA();
                }
            }
        }
    }

    @Override
    public Object del(Integer id) {
        if (id == null) {
            return responMessage.BAD_REUQEST();
        } else {
            TypeUnit t = typeUnitDao.findId(id);
            if (t != null) {
                typeUnitDao.deleteById(id);
                return responMessage.SUCCESS_PROCESS_DATA();
            } else {
                return responMessage.NOT_FOUND("ID");
            }
        }
    }

    @Override
    public Object findById(Integer id) {
        TypeUnit t = typeUnitDao.findId(id);
        if (t != null) {
            return responMessage.SUCCESS_GET(typeUnitDao.findById(id));
        } else {
            return responMessage.NOT_FOUND("ID");
        }
    }
}
