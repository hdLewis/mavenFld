package com.mvca.mapper;

import com.mvca.model.Fld;

import java.util.List;
import java.util.Map;

public interface FldMapper {
    Fld getFldById(int flda);
    int insertFld(Fld fld);
    List<Fld> getFld(Fld fld);
    boolean deleteFld(int flda);
    boolean updateFld(Map map);
}
