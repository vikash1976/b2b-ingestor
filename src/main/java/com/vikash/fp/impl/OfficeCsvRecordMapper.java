package com.vikash.fp.impl;

import java.util.Map;

import com.vikash.fp.interfaces.CsvRecordMapper;

public class OfficeCsvRecordMapper implements CsvRecordMapper<Office> {

	@Override
    public Office map(Map<String, String> csvRecord, int lineNumber) {
        //System.out.println(csvRecord);
    	String id = csvRecord.get("id");
        String name = csvRecord.get("name");
        String address = csvRecord.get("address");
        String primaryDoctor = csvRecord.get("primarydoctor");
        

        return new Office(id, name, address, primaryDoctor);
    }

	
}