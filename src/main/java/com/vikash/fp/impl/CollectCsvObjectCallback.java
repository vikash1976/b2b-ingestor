package com.vikash.fp.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.vikash.fp.application.schema.FileSchema;
import com.vikash.fp.interfaces.CsvObjectCallback;

public class CollectCsvObjectCallback<T> implements CsvObjectCallback<T> {

	private List<T> successfulObjects = new ArrayList<>();
	private List<T> violationFailedObjects = new ArrayList<>();
	private List<FileSchema> schemaEnties = new ArrayList<FileSchema>();

	@Override
	public void process(T object, List<FileSchema> schemaEntries) {

		this.schemaEnties = schemaEntries;
		boolean isObjectValidPerSchema = true;
		try {

			Field[] fields = object.getClass().getDeclaredFields();

			for (Field field : fields) {

				String fieldName = field.getName();

				boolean isFieldPassedValidation = isValidPerSchema(object, fieldName, field);
				if (isFieldPassedValidation) {

					isObjectValidPerSchema = true;
				} else {

					isObjectValidPerSchema = false;
					break;
				}
			}

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		if (isObjectValidPerSchema) {

			successfulObjects.add(object);
		} else {

			violationFailedObjects.add(object);
		}
	}

	public List<T> getSuccessfulObjects() {
		return successfulObjects;
	}

	public List<T> getViolationFailedObjects() {
		return violationFailedObjects;
	}

	private boolean isValidPerSchema(T object, String column, Field field)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		FileSchema schema = findFileSchemaForGivenField(column);

		if (schema.Restrictions.toLowerCase().contains("NotNull".toLowerCase())) {
			return (field.get(object) != null && !field.get(object).equals("null")) ? true : false;
		} else {
			return true;
		}
	}

	private FileSchema findFileSchemaForGivenField(String fieldName) {

		return this.schemaEnties.stream().filter(schema -> fieldName.equalsIgnoreCase(schema.Field)).findAny()
				.orElse(null);

	}

}