package com.mvca.service;

import com.mvca.model.Fld;

import java.util.List;
import java.util.Map;

public interface FldService {
    boolean checkFld(int flda);
    boolean insertFld(Fld fld);
    boolean updateFld(Map map);
    boolean deleteFld(int flda);
    List<Fld> getFld(Fld fld);





}
