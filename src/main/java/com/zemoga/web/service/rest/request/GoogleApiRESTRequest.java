package com.zemoga.web.service.rest.request;

import java.util.Locale;

import com.zemoga.web.util.ApplicationConstants;
import com.zemoga.web.util.PropertiesUtil;

public class GoogleApiRESTRequest extends BaseRESTRequest {
	
	/**	 */
	private static final long serialVersionUID = -8897907210834137133L;
	
	private static final String VERSION = "v";
	private static final String QUERY = "q";
	private static final String uri = PropertiesUtil.getString(ApplicationConstants.GOOGLE_API_URL_KEY);
	
	public GoogleApiRESTRequest() {
		super();
		uriBuilder.append(uri);
	}
	
	public GoogleApiRESTRequest(Locale locale) {
		super(locale);
		uriBuilder.append(uri);
	}
	
	@Override
	public String getServiceUri() {
		return uri;
	}
	
	public GoogleApiRESTRequest version(String version){
		addVariable(VERSION, version);
		return this;
	}
	
	public GoogleApiRESTRequest query(String query){
		addVariable(QUERY, query);
		return this;
	}
	
}
