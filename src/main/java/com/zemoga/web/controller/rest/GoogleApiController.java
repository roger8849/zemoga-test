package com.zemoga.web.controller.rest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.zemoga.web.service.GoogleApiService;
import com.zemoga.web.service.rest.request.GoogleApiRESTRequest;
import com.zemoga.web.util.ApplicationConstants;

@Controller
@RequestMapping("/data")
public class GoogleApiController {

	@Autowired
	GoogleApiService googleApiService;

	@RequestMapping(value = "/getgoogleapi", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.OK)
	public String getGoogleApi(@RequestParam(value = "version", required = false, defaultValue = "1.0") String version,
			@RequestParam(value = "query", required = true) String query, Model model) {

		GoogleApiRESTRequest restRequest = new GoogleApiRESTRequest().version(version).query(query);

		JSONObject jsonResponse = this.googleApiService.getGoogleApiInformation(restRequest);

		model.addAttribute(ApplicationConstants.JSON_RESPONSE_KEY, jsonResponse);
		// returns the view name
		return ApplicationConstants.JSON_VIEWER_KEY;

	}
}
