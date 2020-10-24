package com.vikash.fp.impl;

import java.util.Map;

import com.vikash.fp.interfaces.CsvRecordMapper;

public class DoctorCsvRecordMapper implements CsvRecordMapper<Doctor> {

	@Override
    public Doctor map(Map<String, String> csvRecord, int lineNumber) {
        //System.out.println(csvRecord);
    	String id = csvRecord.get("id");
        String name = csvRecord.get("name");
        

        return new Doctor(id, name);
    }

	
}