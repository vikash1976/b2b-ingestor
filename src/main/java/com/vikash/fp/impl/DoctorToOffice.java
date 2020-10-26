package com.vikash.fp.impl;

public class DoctorToOffice {

	public String doctorid;
	public String officeid;
	
	public DoctorToOffice() {
		
	}
	public DoctorToOffice(String doctorid, String officeid) {
		this.doctorid = doctorid;
		this.officeid = officeid;
	}
	public String getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(String doctorid) {
		this.doctorid = doctorid;
	}
	public String getOfficeid() {
		return officeid;
	}
	public void setOfficeid(String officeid) {
		this.officeid = officeid;
	}
	@Override
    public String toString() {
        return "DoctorToOffice [doctorid=" + doctorid + ", officeid=" + officeid + "]";
    }
}
