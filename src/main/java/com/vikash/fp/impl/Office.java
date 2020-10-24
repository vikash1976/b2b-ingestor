package com.vikash.fp.impl;

public class Office {

    public String id;
    public String name;
    public String address;
    public String primaryDoctor;
   

   public Office(String id, String name, String address, String primaryDoctor) {
    	this.id = id;
        this.name = name;
        this.address = address;
        this.primaryDoctor = primaryDoctor;
	}


	public String getId() {
		return id;
	}



	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPrimaryDoctor() {
		return primaryDoctor;
	}


	public void setPrimaryDoctor(String primaryDoctor) {
		this.primaryDoctor = primaryDoctor;
	}


	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
    public String toString() {
        return "Office [id=" + id + ", name=" + name + ", address=" + address + ", primarydoctor=" + primaryDoctor+ "]";
    }

}