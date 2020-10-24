package com.vikash.fp.interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;

import com.vikash.fp.application.Application;
import com.vikash.fp.application.schema.FileSchema;
import com.vikash.fp.application.schema.SchemaFileReader;
import com.vikash.fp.impl.CollectCsvObjectCallback;
import com.vikash.fp.impl.CsvMetadata;
import com.vikash.fp.impl.RowBasedCsvMetadataSource;
import com.vikash.fp.messages.Messages;

import ch.qos.logback.classic.Logger;

public abstract class AbstractFileReader {
	public CsvMetadataSource csvMetadataSource = null;
	private Logger logger = (Logger) LoggerFactory.getLogger(AbstractFileReader.class);

	public AbstractFileReader() {
	}

	public AbstractFileReader(CsvMetadataSource csvMetadataSource) {
		this.csvMetadataSource = csvMetadataSource;
	}

	public <T> List<T> readAll(Reader csvInputReader, CsvRecordMapper<T> csvLineMapper, List<FileSchema> schemaEntries) throws IOException {
		CsvObjectCallback<T> collectCsvObjectCallback = new CollectCsvObjectCallback<T>();
		read(csvInputReader, csvLineMapper, collectCsvObjectCallback, schemaEntries);
		logger.info(Application.mc.getMessage(Messages.FAILED_RECORDS));
		//System.out.println(Application.mc.getMessage(Messages.FAILED_RECORDS));
		logger.info(((CollectCsvObjectCallback<T>) collectCsvObjectCallback).getViolationFailedObjects().toString());
		return ((CollectCsvObjectCallback<T>) collectCsvObjectCallback).getSuccessfulObjects();
	}

	public <T> void read(Reader csvInputReader, CsvRecordMapper<T> csvLineMapper,
			CsvObjectCallback<T> csvObjectCallback, List<FileSchema> schemaEntries) throws IOException {
		try (BufferedReader lineReader = new BufferedReader(csvInputReader);) {
			CsvMetadataSource effectiveCsvMetadataSource = getCsvMetadataSource(lineReader);

			read(csvLineMapper, csvObjectCallback, lineReader, effectiveCsvMetadataSource, schemaEntries);
		}
	}

	public CsvMetadataSource getCsvMetadataSource(BufferedReader lineReader) throws IOException {
		CsvMetadataSource effectiveCsvMetadataSource = csvMetadataSource;
		if (effectiveCsvMetadataSource == null) {
			String headerLine = lineReader.readLine();
			effectiveCsvMetadataSource = new RowBasedCsvMetadataSource(headerLine);
		}
		return effectiveCsvMetadataSource;
	}

	public <T> void read(CsvRecordMapper<T> csvLineMapper, CsvObjectCallback<T> csvObjectCallback,
			BufferedReader lineReader, CsvMetadataSource effectiveCsvMetadataSource, List<FileSchema> schemaEntries) throws IOException {
		CsvMetadata effectiveCsvMetadata = effectiveCsvMetadataSource.getCsvMetadata();
		if (effectiveCsvMetadata != null) {
			String line;
			int csvRecordNumber = 0;

			while ((line = lineReader.readLine()) != null) {
				Map<String, String> csvRecordValues = effectiveCsvMetadata.parseLine(line);
				T object = csvLineMapper.map(csvRecordValues, csvRecordNumber++);
				csvObjectCallback.process(object, schemaEntries);
			}
		}
	}

}
