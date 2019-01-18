/*
 * Copyright (C) 2017 Sylvain Leroy - BYOS Company All Rights Reserved
 * You may use, distribute and modify this code under the
 * terms of the MIT license, which unfortunately won't be
 * written for another century.
 *
 * You should have received a copy of the MIT license with
 * this file. If not, please write to: contact@sylvainleroy.com, or visit : https://sylvainleroy.com
 */
package io.github.sleroy.sonar;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.sonar.api.config.Configuration;

public class GenericConfiguration implements Configuration {

	@SuppressWarnings("rawtypes")
	private final Map settings = new HashMap();

	@Override
	public Optional<String> get(String key) {
		if (settings.containsKey(key)) {
			return Optional.of(settings.get(key).toString());
		}
		return Optional.empty();
	}

	@Override
	public String[] getStringArray(String key) {
		if (settings.containsKey(key)) {
			return new String[] { settings.get(key).toString() };
		}
		return new String[0];
	}

	@Override
	public boolean hasKey(String key) {
		return settings.containsKey(key);
	}

	/**
	 * Sets the property.
	 *
	 * @param key    the key
	 * @param _value the value
	 */
	@SuppressWarnings("unchecked")
	public void setProperty(String key, int _value) {
		settings.put(key, _value);
	}

	/**
	 * Sets the property.
	 *
	 * @param key    the key
	 * @param _value the value
	 */
	@SuppressWarnings("unchecked")
	public void setProperty(String key, String _value) {
		settings.put(key, _value);
	}
}
