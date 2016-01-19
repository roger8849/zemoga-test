package com.zemoga.web.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class RestHandler {

	private static final String HEADER_NAME_CONTENT_TYPE = "Content-Type";

	private static HttpHeaders httpHeaders = new HttpHeaders();

	private RestTemplate restTemplate = new RestTemplate();

	private String uri;

	static {
		httpHeaders.set(HEADER_NAME_CONTENT_TYPE, "application/json");
	}

	private RestHandler(String uri) {
		this.uri = uri;
	}

	public static RestHandler getInstance(String uri) {
		return new RestHandler(uri);
	}

	public String executePost(String postVariables) {
		return restTemplate
				.exchange(uri, HttpMethod.POST, new HttpEntity<String>(postVariables, httpHeaders), String.class).getBody();
	}

	public String executeGet() {
		return restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<String>(httpHeaders), String.class).getBody();
	}

}