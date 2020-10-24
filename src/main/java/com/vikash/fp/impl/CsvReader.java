package com.vikash.fp.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import com.vikash.fp.application.schema.FileSchema;
import com.vikash.fp.interfaces.AbstractFileReader;
import com.vikash.fp.interfaces.CsvMetadataSource;
import com.vikash.fp.interfaces.CsvObjectCallback;
import com.vikash.fp.interfaces.CsvRecordMapper;

public class CsvReader extends AbstractFileReader {

    //private CsvMetadataSource csvMetadataSource = null;

    public CsvReader() {
    	super();
    }

    public CsvReader(CsvMetadataSource csvMetadataSource) {
        //this.csvMetadataSource = csvMetadataSource;
    	super(csvMetadataSource);
    }

    public <T> List<T> readAll(Reader csvInputReader, CsvRecordMapper<T> csvLineMapper, List<FileSchema> schemaEntries) throws IOException {
        return super.readAll(csvInputReader, csvLineMapper, schemaEntries);
    }

    public <T> void read(Reader csvInputReader, CsvRecordMapper<T> csvLineMapper,
            CsvObjectCallback<T> csvObjectCallback, List<FileSchema> schemaEntries) throws IOException {
        super.read(csvInputReader, csvLineMapper, csvObjectCallback, schemaEntries);
    }

    public CsvMetadataSource getCsvMetadataSource(BufferedReader lineReader) throws IOException {
        return super.getCsvMetadataSource(lineReader);
    }

    public <T> void read(CsvRecordMapper<T> csvLineMapper, CsvObjectCallback<T> csvObjectCallback,
            BufferedReader lineReader, CsvMetadataSource effectiveCsvMetadataSource, List<FileSchema> schemaEntries) throws IOException {
        super.read(csvLineMapper, csvObjectCallback, lineReader, effectiveCsvMetadataSource, schemaEntries);
    }

}