package com.vikash.fp.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvMetadata {

    private List<String> columns;

    public CsvMetadata(List<String> columns) {
        this.columns = columns;
    }

    public Map<String, String> parseLine(String line) {
        // a simple implementation 
        String[] values = line.split(",");

        Map<String, String> record = new HashMap<>();

        for (int i = 0; i < columns.size(); i++) {
            String column = columns.get(i);

            String value = null;

            if (i < values.length) {
                value = values[i];
            }

            record.put(column, value);
        }

        return record;
    }

}