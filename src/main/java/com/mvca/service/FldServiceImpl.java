package com.mvca.service;

import com.mvca.mapper.FldMapper;
import com.mvca.model.Fld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FldServiceImpl implements FldService {
    @Autowired
    FldMapper fldMapper;

    @Override
    public boolean checkFld(int flda) {
        return fldMapper.getFldById(flda)!=null;               //调用jdbc或orm
    }

    @Override
    public boolean insertFld(Fld fld) {
        return fldMapper.insertFld(fld)>0;
    }

    @Override
    public boolean updateFld(Map map) {
        return  fldMapper.updateFld(map);
    }


    @Override
    public boolean deleteFld(int flda) {
        return fldMapper.deleteFld(flda);
    }

    @Override
    public List<Fld> getFld(Fld fld) {
        return fldMapper.getFld(fld);
    }
}
