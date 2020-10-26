package com.vikash.fp.interfaces;

import java.io.IOException;
import java.util.List;

import com.vikash.fp.application.schema.FileSchema;

public interface AbstractFileReader {

	public <T> List<T> readAll(String fileName, CsvRecordMapper<T> csvLineMapper, List<FileSchema> schemaEntries)
			throws IOException;

	public <T> void read(String fileName, CsvRecordMapper<T> csvLineMapper, CsvObjectCallback<T> csvObjectCallback,
			List<FileSchema> schemaEntries) throws IOException;

}
