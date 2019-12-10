package com.alpha.cache.data;

public interface IService {
	Object get(String key);
	void put(String key, Object value);
}

