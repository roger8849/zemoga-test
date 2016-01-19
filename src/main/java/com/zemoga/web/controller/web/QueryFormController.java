package com.zemoga.web.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zemoga.web.util.ApplicationConstants;

@Controller
public class QueryFormController {
	
	@RequestMapping(value = "form")
	public String form(){
		return ApplicationConstants.QUERY_FORM_PATH;
	}
}
