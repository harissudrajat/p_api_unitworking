package com.psdkp.api.unit_working.service.unitWorking.impl;

import com.psdkp.api.unit_working.domain.Facilities;
import com.psdkp.api.unit_working.repository.FacilitiesDao;
import com.psdkp.api.unit_working.service.unitWorking.FacilitiesService;
import com.psdkp.api.unit_working.util.ResponMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilitiesServiceImpl implements FacilitiesService {

    @Autowired
    private ResponMessage responMessage;

    @Autowired
    private FacilitiesDao facilitiesDao;

    @Override
    public Object findAll(String type, Pageable pageable) {
        return responMessage.SUCCESS_GET(facilitiesDao.findAllByName(type, pageable));
    }

    @Override
    public Object save(Facilities facilities) {
        if (facilities.getName().trim().equals("")) {
            return responMessage.BAD_REUQEST();
        } else {
            Facilities t = facilitiesDao.findByName(facilities.getName().trim());
            if (t != null) {
                return responMessage.DUPLICATE("TYPE");
            } else {
                facilitiesDao.save(facilities);
                return responMessage.SUCCESS_PROCESS_DATA();
            }
        }
    }

    @Override
    public Object edit(Facilities facilities) {
        if (facilities.getId() == null || facilities.getName().trim().equals("")) {
            return responMessage.BAD_REUQEST();
        } else {
            Facilities t = facilitiesDao.findId(facilities.getId());
            if (t == null){
                return responMessage.NOT_FOUND("ID");
            } else {
                Facilities t2 = facilitiesDao.findByName(facilities.getName().trim());
                if (t2 != null){
                    return responMessage.DUPLICATE("TYPE");
                } else {
                    facilitiesDao.save(facilities);
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
            Facilities t = facilitiesDao.findId(id);
            if (t != null) {
                facilitiesDao.deleteById(id);
                return responMessage.SUCCESS_PROCESS_DATA();
            } else {
                return responMessage.NOT_FOUND("ID");
            }
        }
    }

    @Override
    public Object findById(Integer id) {
        Facilities t = facilitiesDao.findId(id);
        if (t != null) {
            return responMessage.SUCCESS_GET(facilitiesDao.findById(id));
        } else {
            return responMessage.NOT_FOUND("ID");
        }
    }
}
