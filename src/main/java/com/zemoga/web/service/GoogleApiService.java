package com.zemoga.web.service;

import org.json.JSONObject;

import com.zemoga.web.service.rest.request.BaseRESTRequest;

public interface GoogleApiService {
	
	public JSONObject getGoogleApiInformation(BaseRESTRequest restRequest);
	
}
