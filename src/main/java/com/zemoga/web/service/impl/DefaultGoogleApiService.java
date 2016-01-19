package com.zemoga.web.service.impl;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoga.web.service.GoogleApiService;
import com.zemoga.web.service.RestHandlerService;
import com.zemoga.web.service.rest.request.BaseRESTRequest;
import com.zemoga.web.util.JSONUtils;
@Service()
public class DefaultGoogleApiService implements GoogleApiService{
	
	@Autowired
	RestHandlerService restHandlerService;
	
	@Override
	public JSONObject getGoogleApiInformation(BaseRESTRequest restRequest) {
		
		JSONObject response = null;
		
		try {
			response = restHandlerService.processBaseRequestGet(restRequest);
		} catch (Exception e){
			response = JSONUtils.getInstance().getGeneralErrorResponse();
		}
		return response;
	}

}
