package com.vikash.fp.application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.vikash.fp.application.schema.FileSchema;
import com.vikash.fp.application.schema.SchemaFileReader;
import com.vikash.fp.impl.CsvReader;
import com.vikash.fp.impl.Doctor;
import com.vikash.fp.impl.DoctorCsvRecordMapper;
import com.vikash.fp.impl.Office;
import com.vikash.fp.impl.OfficeCsvRecordMapper;
import com.vikash.fp.messages.Messages;
import java.util.Locale;

import org.slf4j.LoggerFactory;

import ch.qos.cal10n.IMessageConveyor;
import ch.qos.cal10n.MessageConveyor;
import ch.qos.logback.classic.Logger;

public class Application {
	public static IMessageConveyor mc = new MessageConveyor(Locale.GERMANY);
	private static final Logger logger = (Logger) LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) throws IOException {
		
		logger.info(mc.getMessage(Messages.FILE_PROCESSING, args[1], args[0]));
		//System.out.println(mc.getMessage(Messages.FILE_PROCESSING, args[1], args[0]));
		List<FileSchema> schemaEntries = readSchemaTSVIntoObjects(args[1], '\u0009');
		readCsvFile(args[0], schemaEntries);
	}

	public static void readCsvFile(String csvFileName, List<FileSchema> schemaEntries) throws IOException {

		InputStream csvInputStream = new FileInputStream(Constants.inputFolder + csvFileName);
		// Application.class.getResourceAsStream("doctors.csv");
		InputStreamReader inputStreamReader = new InputStreamReader(csvInputStream);

		CsvReader csvReader = new CsvReader();
		if (csvFileName.contains("doctors")) {
			List<Doctor> doctors = csvReader.readAll(inputStreamReader, new DoctorCsvRecordMapper(), schemaEntries);
			
			logger.info(mc.getMessage(Messages.SUCCESSFULL_RECORDS));
			//System.out.println(mc.getMessage(Messages.SUCCESSFULL_RECORDS));
			for (Doctor doctor : doctors) {
				logger.info(doctor.toString());
				//System.out.println(doctor);
			}
		}
		if (csvFileName.contains("offices")) {
			List<Office> offices = csvReader.readAll(inputStreamReader, new OfficeCsvRecordMapper(), schemaEntries);
			logger.info(mc.getMessage(Messages.SUCCESSFULL_RECORDS));
			//System.out.println("Records good for further processing:");
			for (Office office : offices) {
				logger.info(office.toString());
				//System.out.println(office);
			}
		}
		
	}

	public static List<FileSchema> readSchemaTSVIntoObjects(String schemaFileName, char separatorChar) throws IOException {
		return SchemaFileReader.readSchemaIntoObjects(schemaFileName, separatorChar);
	}
}
