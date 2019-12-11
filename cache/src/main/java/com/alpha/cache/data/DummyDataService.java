package com.alpha.cache.data;

import org.springframework.stereotype.Component;

@Component("dummyDataService")
public class DummyDataService implements IService {

	public Object get(String key) {
		// Error handling is an interesting question here.
		// We can assume that it return null for error
		return "Dummy data for key: " + key;
	}

	public void put(String key, Object value) {
		// Error handling is an interesting question here.
		// It would be nice if this throws an Exception
		// Leaving this as it is as the questions did mention
		// an interface without exception
	}
}
