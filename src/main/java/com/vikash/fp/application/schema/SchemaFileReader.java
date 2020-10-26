package com.vikash.fp.application.schema;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.vikash.fp.application.Constants;

public class SchemaFileReader {
	private static List<FileSchema> schemaEntries = null;
	
	public static List<FileSchema> getSchemaEntries() {
		return schemaEntries;
	}

	public static void setSchemaEntries(List<FileSchema> schemaEntries) {
		SchemaFileReader.schemaEntries = schemaEntries;
	}

	public static List<FileSchema> readSchemaIntoObjects(String schemaFileName, char separatorChar) throws IOException {
		InputStream csvSchemaInputStream = new FileInputStream(Constants.inputFolder + schemaFileName);
		char colSeparator = (separatorChar != '\0') ? separatorChar : CsvSchema.DEFAULT_COLUMN_SEPARATOR;
		CsvSchema bootstrap = CsvSchema.emptySchema().withHeader().withColumnSeparator(colSeparator);

		CsvMapper csvMapper = new CsvMapper();
		// csvMapper.registerModule(new SimpleModule().addDeserializer(Object.class, new
		// ForceStringDeserializer()));

		MappingIterator<FileSchema> mappingIterator = csvMapper.reader(FileSchema.class).with(bootstrap)
				.readValues(csvSchemaInputStream);

		schemaEntries = mappingIterator.readAll();
		/*
		 * for (FileSchema schema : schemaEntries) { }
		 */
		return schemaEntries;
	}
}
