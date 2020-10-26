package com.vikash.fp.impl;

import java.util.Arrays;
import java.util.StringTokenizer;

import com.vikash.fp.interfaces.CsvMetadataSource;

public class RowBasedCsvMetadataSource implements CsvMetadataSource {

    private String row;

    public RowBasedCsvMetadataSource(String row) {
        this.row = row;
    }

    @Override
    public CsvMetadata getCsvMetadata() {
        String[] columns = row.split(",");
        return new CsvMetadata(Arrays.asList(columns));
    }

}

