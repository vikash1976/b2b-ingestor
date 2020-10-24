package com.vikash.fp.impl;

import com.vikash.fp.application.schema.FileSchema;

public class User {

    private String firstname;
    private String lastname;
    private String username;
    private String email;

    public User(String firstname, String lastname, String username, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public boolean validateAgainstSchemaDef(FileSchema schemaEntry) {
		return true;
	}
    @Override
    public String toString() {
        return "User [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", email=" + email
                + "]";
    }

}
