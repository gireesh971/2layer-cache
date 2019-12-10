package com.alpha.cache.service;

public interface ICache {
	Object get(String key);
	void put(String key, Object value);
}
