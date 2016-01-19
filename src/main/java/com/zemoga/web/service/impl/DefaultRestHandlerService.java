package com.zemoga.web.service.impl;

import org.apache.commons.lang3.StringEscapeUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.zemoga.web.service.RestHandler;
import com.zemoga.web.service.RestHandlerService;
import com.zemoga.web.service.rest.request.BaseRESTRequest;


@Service("restHandlerService")
public class DefaultRestHandlerService implements RestHandlerService {


	@Override
	public JSONObject processBaseRequestGet(BaseRESTRequest request)
			throws JSONException {
		String uri = request.getCompleteUri();
		JSONObject response = null;
		String result = RestHandler.getInstance(uri).executeGet();
		response = new JSONObject(result);
		return response;
	}
	
	@Override
	public JSONObject processBaseRequestPost(BaseRESTRequest request)
			throws JSONException {
		String uri = request.getCompleteUri();
		JSONObject response = null;
		//sending variables via body
		String result = StringEscapeUtils.escapeHtml4(RestHandler.getInstance(request.getServiceUri()).executePost(request.getVariablesToJson()));
		response = new JSONObject(result);
		return response;

	}

}
