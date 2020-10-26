package com.vikash.fp.application.alternates;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.exception.SuperCsvConstraintViolationException;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.vikash.fp.application.Application;
import com.vikash.fp.application.Constants;
import com.vikash.fp.impl.Doctor;
import com.vikash.fp.messages.Messages;

import ch.qos.logback.classic.Logger;

public class SuperCSVParserSample {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(SuperCSVParserSample.class);
	public void processCSV() {
		
		List<Doctor> docs = new ArrayList<Doctor>();
		docs = readCSVToBean();

		logger.info(Application.mc.getMessage(Messages.SUCCESSFULL_RECORDS));
		logger.info(docs.toString());
		logger.info("****************************************************");
	}

	private static List<Doctor> readCSVToBean() {
		ICsvBeanReader beanReader = null;
		List<Doctor> docs = new ArrayList<Doctor>();
		try {
			try {
				beanReader = new CsvBeanReader(new FileReader(Constants.inputFolder + "doctors.csv"),
						CsvPreference.STANDARD_PREFERENCE);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// the name mapping provide the basis for bean setters
			final String[] nameMapping = new String[] { "id", "name" };
			// just read the header, so that it don't get mapped to Employee object
			final String[] header = beanReader.getHeader(true);
			final CellProcessor[] processors = getProcessors();

			Doctor doc;

			while ((doc = beanReader.read(Doctor.class, nameMapping, processors)) != null) {
				docs.add(doc);
			}

		} catch (SuperCsvCellProcessorException e) {
			logger.info(Application.mc.getMessage(Messages.FAIL_STOP_MEAASE, e.getCsvContext().toString()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (beanReader != null) {
				try {
					beanReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return docs;

	}

	private static CellProcessor[] getProcessors() {

		final CellProcessor[] processors = new CellProcessor[] { new UniqueHashCode(), // ID (must be unique)
				new NotNull(), // Name
				// new Optional(), // Role
				// new NotNull() // Salary
		};
		return processors;
	}

}
