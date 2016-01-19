package com.zemoga.web.service.rest.request;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.google.gson.Gson;

public abstract class BaseRESTRequest implements Serializable {
	
	public static final long serialVersionUID = 739404834623839451L;
	
	protected static final String QUESTION_MARK = "?";
	protected static final String LANG_CODE = "langCode";
	protected static final String COMMA = ",";
	protected static final String AMPERSAND = "&";
	protected static final String EQUALS = "=";
	protected static final String SLASH = "/";

	private Gson gson = new Gson();

	protected StringBuilder uriBuilder;
	protected Locale locale;

	protected String completeUri;

	protected Map<String, Object> variables;

	public BaseRESTRequest() {
		variables = new HashMap<String, Object>();
		uriBuilder = new StringBuilder();
	}

	public BaseRESTRequest(Locale locale) {
		this();
		this.locale = locale;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public void addVariable(String variableName, Object value) {
		if (uriBuilder.indexOf(QUESTION_MARK) == -1) {
			uriBuilder.append(QUESTION_MARK);
		}
		uriBuilder.append(variableName);
		uriBuilder.append(EQUALS);
		uriBuilder.append(value);
		uriBuilder.append(AMPERSAND);
		variables.put(variableName, value);
	}

	public void addParameterToUrl(String parameter) {
		uriBuilder.append(SLASH);
		uriBuilder.append(parameter);
	}

	public void addArray(String variableName, List<String> array) {
		uriBuilder.append(variableName);
		uriBuilder.append(EQUALS);
		for (String value : array) {
			uriBuilder.append(value);
			uriBuilder.append(COMMA);
		}
		deleteLastCharacter();
		uriBuilder.append(AMPERSAND);
		variables.put(variableName, array);
	}

	private void deleteLastCharacter() {
		uriBuilder.deleteCharAt(uriBuilder.length() - 1);
	}

	public String getCompleteUri() {
		if (completeUri == null) {
			completeUri = uriBuilder.toString();
		}
		return completeUri;
	}

	public Map<String, Object> getVariables() {
		return variables;
	}

	public String getVariablesToJson() {
		return gson.toJson(variables);
	}

	public abstract String getServiceUri();
	
}
