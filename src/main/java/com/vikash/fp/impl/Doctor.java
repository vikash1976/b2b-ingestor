package com.vikash.fp.impl;

import com.vikash.fp.application.schema.FileSchema;

public class Doctor {

	public String id;
	public String name;
   

    public Doctor(String id, String name) {
    	 this.id = id;
         this.name = name;
	}


    public String getId() {
		return id;
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



	public boolean validateAgainstSchemaDef(FileSchema schemaEntry) {
		return true;
	}
	@Override
    public String toString() {
        return "Doctor [id=" + id + ", name=" + name + "]";
    }

}