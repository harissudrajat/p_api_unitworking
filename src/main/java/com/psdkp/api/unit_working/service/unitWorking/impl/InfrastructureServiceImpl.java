package com.psdkp.api.unit_working.service.unitWorking.impl;

import com.psdkp.api.unit_working.domain.Infrastructure;
import com.psdkp.api.unit_working.repository.InfrastructureDao;
import com.psdkp.api.unit_working.service.unitWorking.InfrastructureService;
import com.psdkp.api.unit_working.util.ResponMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InfrastructureServiceImpl implements InfrastructureService {

    @Autowired
    private ResponMessage responMessage;

    @Autowired
    private InfrastructureDao infrastructureDao;

    @Override
    public Object findAll(String type, Pageable pageable) {
        return responMessage.SUCCESS_GET(infrastructureDao.findAllByName(type, pageable));
    }

    @Override
    public Object save(Infrastructure infrastructure) {
        if (infrastructure.getName().trim().equals("")) {
            return responMessage.BAD_REUQEST();
        } else {
            Infrastructure t = infrastructureDao.findByName(infrastructure.getName().trim());
            if (t != null) {
                return responMessage.DUPLICATE("TYPE");
            } else {
                infrastructureDao.save(infrastructure);
                return responMessage.SUCCESS_PROCESS_DATA();
            }
        }
    }

    @Override
    public Object edit(Infrastructure infrastructure) {
        if (infrastructure.getId() == null || infrastructure.getName().trim().equals("")) {
            return responMessage.BAD_REUQEST();
        } else {
            Infrastructure t = infrastructureDao.findId(infrastructure.getId());
            if (t == null){
                return responMessage.NOT_FOUND("ID");
            } else {
                Infrastructure t2 = infrastructureDao.findByName(infrastructure.getName().trim());
                if (t2 != null){
                    return responMessage.DUPLICATE("TYPE");
                } else {
                    infrastructureDao.save(infrastructure);
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
            Infrastructure t = infrastructureDao.findId(id);
            if (t != null) {
                infrastructureDao.deleteById(id);
                return responMessage.SUCCESS_PROCESS_DATA();
            } else {
                return responMessage.NOT_FOUND("ID");
            }
        }
    }

    @Override
    public Object findById(Integer id) {
        Infrastructure t = infrastructureDao.findId(id);
        if (t != null) {
            return responMessage.SUCCESS_GET(infrastructureDao.findById(id));
        } else {
            return responMessage.NOT_FOUND("ID");
        }
    }
}
