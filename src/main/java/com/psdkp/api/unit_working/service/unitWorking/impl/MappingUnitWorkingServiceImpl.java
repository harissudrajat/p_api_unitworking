package com.psdkp.api.unit_working.service.unitWorking.impl;

import com.psdkp.api.unit_working.domain.MappingUnitWorking;
import com.psdkp.api.unit_working.domain.UnitWorking;
import com.psdkp.api.unit_working.repository.MappingUnitWorkingDao;
import com.psdkp.api.unit_working.repository.UnitWorkingDao;
import com.psdkp.api.unit_working.service.unitWorking.MappingUnitWorkingService;
import com.psdkp.api.unit_working.util.ResponMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MappingUnitWorkingServiceImpl implements MappingUnitWorkingService {

    @Autowired
    private MappingUnitWorkingDao mappingUnitWorkingDao;

    @Autowired
    private UnitWorkingDao unitWorkingDao;

    @Autowired
    private ResponMessage responMessage;

    @Override
    public Object findAll(String name, Pageable pageable) {
        return responMessage.SUCCESS_GET(mappingUnitWorkingDao.findAll(pageable));
    }

    @Override
    public Object save(MappingUnitWorking mappingUnitWorking) {
        if (mappingUnitWorking.getParrent().getId() == null || mappingUnitWorking.getChild().getId() == null || mappingUnitWorking.getUpt().getId() == null) {
            return responMessage.BAD_REUQEST();
        } else {
            UnitWorking a = unitWorkingDao.findId(mappingUnitWorking.getParrent().getId());
            UnitWorking b = unitWorkingDao.findId(mappingUnitWorking.getChild().getId());
            UnitWorking c = unitWorkingDao.findId(mappingUnitWorking.getUpt().getId());

            if (c != null) {
                if (a != null) {
                    if (b != null) {
                        if (a.getTypeUnit().getType().equals("UPT")) {
                            mappingUnitWorkingDao.save(mappingUnitWorking);
                            return responMessage.SUCCESS_PROCESS_DATA();
                        } else if (a.getTypeUnit().getType().equals("SATWAS")){
                            mappingUnitWorkingDao.save(mappingUnitWorking);
                            return responMessage.SUCCESS_PROCESS_DATA();
                        } else{
                            return responMessage.NOT_ALLOW();
                        }
                    }else{
                        return responMessage.NOT_FOUND("ID CHILD");
                    }
                }else{
                    return responMessage.NOT_FOUND("ID PARRENT");
                }
            } else {
                return responMessage.NOT_FOUND("ID UPT");
            }
        }
    }

    @Override
    public Object edit(MappingUnitWorking mappingUnitWorking) {
        if (mappingUnitWorking.getId() == null || mappingUnitWorking.getParrent().getId() == null || mappingUnitWorking.getChild().getId() == null) {
            return responMessage.BAD_REUQEST();
        } else {
            MappingUnitWorking mapping = mappingUnitWorkingDao.findId(mappingUnitWorking.getId());
            if (mapping != null) {
                UnitWorking a = unitWorkingDao.findId(mappingUnitWorking.getParrent().getId());
                UnitWorking b = unitWorkingDao.findId(mappingUnitWorking.getChild().getId());
                UnitWorking c = unitWorkingDao.findId(mappingUnitWorking.getUpt().getId());

                if (c != null) {
                    if (a != null) {
                        if (b != null) {
                            if (a.getTypeUnit().getType().equals("UPT")) {
                                mappingUnitWorkingDao.save(mappingUnitWorking);
                                return responMessage.SUCCESS_PROCESS_DATA();
                            } else if (a.getTypeUnit().getType().equals("SATWAS")){
                                mappingUnitWorkingDao.save(mappingUnitWorking);
                                return responMessage.SUCCESS_PROCESS_DATA();
                            } else{
                                return responMessage.NOT_ALLOW();
                            }
                        }else{
                            return responMessage.NOT_FOUND("ID CHILD");
                        }
                    }else{
                        return responMessage.NOT_FOUND("ID PARRENT");
                    }
                } else {
                    return responMessage.NOT_FOUND("ID UPT");
                }
            } else {
                return responMessage.NOT_FOUND("ID");
            }
        }
    }

    @Override
    public Object del(Integer id) {
        if (id == null) {
            return responMessage.BAD_REUQEST();
        } else {
            MappingUnitWorking mapping = mappingUnitWorkingDao.findId(id);
            if (mapping != null) {
                mappingUnitWorkingDao.deleteById(id);
                return responMessage.SUCCESS_PROCESS_DATA();
            } else {
                return responMessage.NOT_FOUND("ID");
            }
        }
    }

    @Override
    public Object findById(Integer id) {
        MappingUnitWorking mapping = mappingUnitWorkingDao.findId(id);
        return responMessage.SUCCESS_GET(mapping);
    }

    @Override
    public Object findByParrent(Integer id, Pageable pageable) {
        if (id == null) {
            return responMessage.BAD_REUQEST();
        } else {
            Page<MappingUnitWorking> mappingUnitWorkings = mappingUnitWorkingDao.findAllByType(id, pageable);
            if (mappingUnitWorkings != null) {
                return responMessage.SUCCESS_GET(mappingUnitWorkings);
            } else {
                return responMessage.NOT_FOUND("ID PARRENT");
            }
        }
    }

    @Override
    public Object findByUpt(Integer id, Pageable pageable) {
        if (id == null) {
            return responMessage.BAD_REUQEST();
        } else {
            Page<MappingUnitWorking> mappingUnitWorkings = mappingUnitWorkingDao.findByUptId(id, pageable);
            if (mappingUnitWorkings != null) {
                return responMessage.SUCCESS_GET(mappingUnitWorkings);
            } else {
                return responMessage.NOT_FOUND("ID UPT");
            }
        }
    }
}
