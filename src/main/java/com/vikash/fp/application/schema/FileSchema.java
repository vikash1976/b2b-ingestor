package com.vikash.fp.application.schema;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "Field", "Type", "Restrictions"})
public class FileSchema {

	public String Field;
    public String Type;
    public String Restrictions;
    
    @Override
    public String toString() {
        return "Schema Entry [Field=" + Field + ", Type=" + Type + ", Restrictions=" + Restrictions + "]";
    }
}
