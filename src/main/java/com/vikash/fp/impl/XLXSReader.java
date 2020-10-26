package com.vikash.fp.impl;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class XLXSReader implements AbstractFileReader {

	private CsvMetadataSource csvMetadataSource = null;
	private Logger logger = (Logger) LoggerFactory.getLogger(XLXSReader.class);

	public XLXSReader() {

	}

	public XLXSReader(CsvMetadataSource csvMetadataSource) {

	}

	@Override
	public <T> List<T> readAll(String fileName, CsvRecordMapper<T> csvLineMapper, List<FileSchema> schemaEntries)
			throws IOException {
		CsvObjectCallback<T> collectCsvObjectCallback = new CollectCsvObjectCallback<T>();
		read(fileName, csvLineMapper, collectCsvObjectCallback, schemaEntries);
		
		logger.info(Application.mc.getMessage(Messages.FAILED_RECORDS));
		
		logger.info(((CollectCsvObjectCallback<T>) collectCsvObjectCallback).getViolationFailedObjects().toString());
		
		return ((CollectCsvObjectCallback<T>) collectCsvObjectCallback).getSuccessfulObjects();

	}

	@Override
	public <T> void read(String fileName, CsvRecordMapper<T> csvLineMapper, CsvObjectCallback<T> csvObjectCallback,
			List<FileSchema> schemaEntries) throws IOException {
		File file = new File(Constants.inputFolder + fileName);

		XSSFWorkbook myWorkBook = null;
		try {
			myWorkBook = new XSSFWorkbook(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}

		XSSFSheet mySheet = myWorkBook.getSheetAt(0);

		Iterator<Row> iterator = mySheet.iterator();
		Row headerRow = iterator.next(); // read header row.

		CsvMetadataSource effectiveCsvMetadataSource = getCsvMetadataSource(headerRow);

		read(csvLineMapper, csvObjectCallback, iterator, effectiveCsvMetadataSource, schemaEntries);

		myWorkBook.close();

	}

	private CsvMetadataSource getCsvMetadataSource(Row headerRow) throws IOException {
		CsvMetadataSource effectiveCsvMetadataSource = csvMetadataSource;
		if (effectiveCsvMetadataSource == null) {
			Iterator<Cell> headerCellIterator = headerRow.cellIterator();

			String columnNames = null;
			while (headerCellIterator.hasNext()) {
				Cell cell = headerCellIterator.next();
				if (columnNames == null) {
					columnNames = cell.getStringCellValue();
				} else {
					columnNames += "," + cell.getStringCellValue();
				}
			}
			effectiveCsvMetadataSource = new RowBasedCsvMetadataSource(columnNames);
		}
		return effectiveCsvMetadataSource;
	}

	private <T> void read(CsvRecordMapper<T> csvLineMapper, CsvObjectCallback<T> csvObjectCallback,
			Iterator<Row> iterator, CsvMetadataSource effectiveCsvMetadataSource, List<FileSchema> schemaEntries)
			throws IOException {
		CsvMetadata effectiveCsvMetadata = effectiveCsvMetadataSource.getCsvMetadata();
		if (effectiveCsvMetadata != null) {
			String line;
			int csvRecordNumber = 0;

			while (iterator.hasNext()) {
				String csvRow = null;
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();
					if (csvRow == null) {
						csvRow = cell.getStringCellValue();
					} else {
						csvRow += "," + cell.getStringCellValue();
					}
				}

				Map<String, String> csvRecordValues = effectiveCsvMetadata.parseLine(csvRow);

				T object = csvLineMapper.map(csvRecordValues, csvRecordNumber++);

				csvObjectCallback.process(object, schemaEntries);
			}
		}
	}
}