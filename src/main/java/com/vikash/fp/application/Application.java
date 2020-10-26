package com.vikash.fp.application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import org.slf4j.LoggerFactory;

import com.vikash.fp.application.schema.FileSchema;
import com.vikash.fp.application.schema.SchemaFileReader;
import com.vikash.fp.impl.CsvReader;
import com.vikash.fp.impl.Doctor;
import com.vikash.fp.impl.DoctorCsvRecordMapper;
import com.vikash.fp.impl.DoctorToOffice;
import com.vikash.fp.impl.DoctorToOfficeCsvRecordMapper;
import com.vikash.fp.impl.Office;
import com.vikash.fp.impl.OfficeCsvRecordMapper;
import com.vikash.fp.impl.XLXSReader;
import com.vikash.fp.interfaces.AbstractFileReader;
import com.vikash.fp.messages.Messages;

import ch.qos.cal10n.IMessageConveyor;
import ch.qos.cal10n.MessageConveyor;
import ch.qos.logback.classic.Logger;

public class Application {
	public static IMessageConveyor mc = new MessageConveyor(Locale.ENGLISH);
	private static final Logger logger = (Logger) LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws IOException {

		logger.info(mc.getMessage(Messages.FILE_PROCESSING, args[1], args[0]));
		
		List<FileSchema> schemaEntries = readSchemaTSVIntoObjects(args[1], '\u0009');
		logger.info(mc.getMessage(Messages.SCHEMA_ENTRIES));
		logger.info(schemaEntries.toString());
		readCsvFile(args[0], schemaEntries);
	}

	public static void readCsvFile(String inputFileName, List<FileSchema> schemaEntries) throws IOException {

		InputStream csvInputStream = new FileInputStream(Constants.inputFolder + inputFileName);
		// Application.class.getResourceAsStream("doctors.csv");
		InputStreamReader inputStreamReader = new InputStreamReader(csvInputStream);
		String fileExtension = inputFileName.split(Pattern.quote("."))[1];
		if (fileExtension.equalsIgnoreCase("csv")) {
			AbstractFileReader csvReader = new CsvReader();
			if (inputFileName.contains("doctors")) {
				List<Doctor> doctors = csvReader.readAll(inputFileName, new DoctorCsvRecordMapper(), schemaEntries);

				logger.info(mc.getMessage(Messages.SUCCESSFULL_RECORDS));
				
				for (Doctor doctor : doctors) {
					logger.info(doctor.toString());
				}
			}
			if (inputFileName.contains("offices")) {
				List<Office> offices = csvReader.readAll(inputFileName, new OfficeCsvRecordMapper(), schemaEntries);
				logger.info(mc.getMessage(Messages.SUCCESSFULL_RECORDS));
				
				for (Office office : offices) {
					logger.info(office.toString());
				}
			}
		}
		if(fileExtension.equalsIgnoreCase("xlsx")) {
			logger.info("Processing XLSX file");
			AbstractFileReader xlsxReader = new XLXSReader();
			List<DoctorToOffice> doctorToOfficeList = xlsxReader.readAll(inputFileName, new DoctorToOfficeCsvRecordMapper(), schemaEntries);
			logger.info(mc.getMessage(Messages.SUCCESSFULL_RECORDS));
			
			for (DoctorToOffice doctorToOffice : doctorToOfficeList) {
				logger.info(doctorToOffice.toString());
			}
		}

	}

	public static List<FileSchema> readSchemaTSVIntoObjects(String schemaFileName, char separatorChar)
			throws IOException {
		return SchemaFileReader.readSchemaIntoObjects(schemaFileName, separatorChar);
	}
}
