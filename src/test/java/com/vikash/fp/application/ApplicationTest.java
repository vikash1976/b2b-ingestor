package com.vikash.fp.application;

import java.io.IOException;

import org.junit.Test;

public class ApplicationTest {

	@Test
	public void doctorsFileIngestTest() throws IOException {
		String[] args = {"doctors.csv", "doctorSchema.txt"};
		Application.main(args);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	@Test
	public void officeFileIngestTest() throws IOException {
		String[] args = {"offices.csv", "officeSchema.txt"};
		Application.main(args);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	@Test
	public void doctorToOfficeFileIngestTest() throws IOException {
		String[] args = {"doctorToOffice.xlsx", "doctorToOfficeSchema.txt"};
		Application.main(args);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

}
