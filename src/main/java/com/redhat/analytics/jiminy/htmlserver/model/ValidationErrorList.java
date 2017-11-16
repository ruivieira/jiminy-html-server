package com.redhat.analytics.jiminy.htmlserver.model;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorList {
	private List<ErrorDAO> errorList = new ArrayList<>();

	public void add(String name, String msg) {
		ErrorDAO error = new ErrorDAO(name, msg);
		errorList.add(error);

	}
}
