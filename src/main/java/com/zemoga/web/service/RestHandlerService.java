package com.zemoga.web.service;

import org.json.JSONException;
import org.json.JSONObject;

import com.zemoga.web.service.rest.request.BaseRESTRequest;


public interface RestHandlerService {

	JSONObject processBaseRequestGet(BaseRESTRequest request) throws JSONException;

	JSONObject processBaseRequestPost(BaseRESTRequest request) throws JSONException;
	
}
