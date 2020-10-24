package com.vikash.fp.application;

import java.io.IOException;

import org.junit.Test;

public class ApplicationTest {

	@Test
	public void doctorsFileIngestTest() throws IOException {
		String[] args = {"doctors.csv", "doctorSchema.csv"};
		Application.main(args);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	@Test
	public void officeFileIngestTest() throws IOException {
		String[] args = {"offices.csv", "officeSchema.csv"};
		Application.main(args);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

}
