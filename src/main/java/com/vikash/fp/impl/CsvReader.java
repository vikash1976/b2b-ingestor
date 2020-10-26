package com.vikash.fp.impl;

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
import com.vikash.fp.interfaces.AbstractFileReader;
import com.vikash.fp.interfaces.CsvMetadataSource;
import com.vikash.fp.interfaces.CsvObjectCallback;
import com.vikash.fp.interfaces.CsvRecordMapper;
import com.vikash.fp.messages.Messages;

import ch.qos.logback.classic.Logger;

public class CsvReader implements AbstractFileReader {

	private CsvMetadataSource csvMetadataSource = null;
	private Logger logger = (Logger) LoggerFactory.getLogger(CsvReader.class);


	public CsvReader() {
		
	}

	public CsvReader(CsvMetadataSource csvMetadataSource) {
		this.csvMetadataSource = csvMetadataSource;
		
	}

	public <T> List<T> readAll(String fileName, CsvRecordMapper<T> csvLineMapper, List<FileSchema> schemaEntries)
			throws IOException {
		CsvObjectCallback<T> collectCsvObjectCallback = new CollectCsvObjectCallback<T>();
		read(fileName, csvLineMapper, collectCsvObjectCallback, schemaEntries);
		logger.info(Application.mc.getMessage(Messages.FAILED_RECORDS));
		logger.info(((CollectCsvObjectCallback<T>) collectCsvObjectCallback).getViolationFailedObjects().toString());
		return ((CollectCsvObjectCallback<T>) collectCsvObjectCallback).getSuccessfulObjects();
	}

	public <T> void read(String fileName, CsvRecordMapper<T> csvLineMapper,
			CsvObjectCallback<T> csvObjectCallback, List<FileSchema> schemaEntries) throws IOException {
		try (InputStream csvInputStream = new FileInputStream(Constants.inputFolder + fileName);
				// Application.class.getResourceAsStream("doctors.csv");
				InputStreamReader inputStreamReader = new InputStreamReader(csvInputStream);
				BufferedReader lineReader = new BufferedReader(inputStreamReader);) {
			CsvMetadataSource effectiveCsvMetadataSource = getCsvMetadataSource(lineReader);

			read(csvLineMapper, csvObjectCallback, lineReader, effectiveCsvMetadataSource, schemaEntries);
		}
	}

	private CsvMetadataSource getCsvMetadataSource(BufferedReader lineReader) throws IOException {
		CsvMetadataSource effectiveCsvMetadataSource = csvMetadataSource;
		if (effectiveCsvMetadataSource == null) {
			String headerLine = lineReader.readLine();
			effectiveCsvMetadataSource = new RowBasedCsvMetadataSource(headerLine);
		}
		return effectiveCsvMetadataSource;
	}

	private <T> void read(CsvRecordMapper<T> csvLineMapper, CsvObjectCallback<T> csvObjectCallback,
			BufferedReader lineReader, CsvMetadataSource effectiveCsvMetadataSource, List<FileSchema> schemaEntries)
			throws IOException {
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