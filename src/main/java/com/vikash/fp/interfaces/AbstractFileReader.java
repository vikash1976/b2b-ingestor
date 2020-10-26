package com.vikash.fp.interfaces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;

import com.vikash.fp.application.Application;
import com.vikash.fp.application.Constants;
import com.vikash.fp.application.schema.FileSchema;
import com.vikash.fp.application.schema.SchemaFileReader;
import com.vikash.fp.impl.CollectCsvObjectCallback;
import com.vikash.fp.impl.CsvMetadata;
import com.vikash.fp.impl.RowBasedCsvMetadataSource;
import com.vikash.fp.messages.Messages;

import ch.qos.logback.classic.Logger;

public interface AbstractFileReader {	

	public <T> List<T> readAll(String fileName, CsvRecordMapper<T> csvLineMapper, List<FileSchema> schemaEntries)
			throws IOException ;

	public <T> void read(String fileName, CsvRecordMapper<T> csvLineMapper, CsvObjectCallback<T> csvObjectCallback,
			List<FileSchema> schemaEntries) throws IOException;

	
}
