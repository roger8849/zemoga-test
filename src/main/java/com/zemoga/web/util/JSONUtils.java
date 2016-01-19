package com.zemoga.web.util;

import org.json.JSONObject;

public class JSONUtils {
	public static JSONUtils instance;
	
	public static JSONUtils getInstance(){
		if (instance == null) {
			instance = new JSONUtils();
		}
		return instance;
	}
	
	public JSONObject getGeneralErrorResponse(){
		JSONObject response = new JSONObject();
		response.append(ApplicationConstants.ERROR_JSON_KEY, "General error trying to parse the response");
		return response;
	}
	
}
