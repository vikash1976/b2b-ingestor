package com.vikash.fp.impl;

import java.util.Map;

import com.vikash.fp.interfaces.CsvRecordMapper;

public class UserCsvRecordMapper implements CsvRecordMapper<User> {

    public User map(Map<String, String> csvRecord, int lineNumber) {
        String firstname = csvRecord.get("FIRST NAME");
        String lastname = csvRecord.get("LAST NAME");
        String username = csvRecord.get("USERNAME");
        String email = csvRecord.get("EMAIL ADDRESS");

        return new User(firstname, lastname, username, email);
    }
}