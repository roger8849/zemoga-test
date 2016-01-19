package com.zemoga.web.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertiesUtil extends PropertyPlaceholderConfigurer {

	private static Map<String, String> properties = new HashMap<String, String>();

	@Override
	protected void loadProperties(final Properties props) throws IOException {
		super.loadProperties(props);
		for (final Object key : props.keySet()) {
			properties.put((String) key, props.getProperty((String) key));
		}
	}
	public static String getString(final String key) {
		return properties.get(key);
	}

	public static boolean getBoolean(final String key) {
		return Boolean.parseBoolean(properties.get(key));
	}
	public static Integer getInteger(final String key) {
		return Integer.parseInt(properties.get(key));
	}
}
