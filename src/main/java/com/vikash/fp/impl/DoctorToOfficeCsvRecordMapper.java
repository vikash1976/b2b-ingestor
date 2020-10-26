package com.vikash.fp.impl;

import java.util.Map;

import com.vikash.fp.interfaces.CsvRecordMapper;

public class DoctorToOfficeCsvRecordMapper implements CsvRecordMapper<DoctorToOffice> {

	@Override
    public DoctorToOffice map(Map<String, String> csvRecord, int lineNumber) {
        
    	String id = csvRecord.get("doctorid");
        String name = csvRecord.get("officeid");
        

        return new DoctorToOffice(id, name);
    }

	
}