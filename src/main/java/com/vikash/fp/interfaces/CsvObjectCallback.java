package com.vikash.fp.interfaces;

import java.util.List;

import com.vikash.fp.application.schema.FileSchema;

public interface CsvObjectCallback<T> {
    public void process(T object, List<FileSchema> schemaEntries);
}
