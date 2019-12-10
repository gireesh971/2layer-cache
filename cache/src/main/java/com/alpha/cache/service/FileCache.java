package com.alpha.cache.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("fileCache")
public class FileCache implements ICache {

	// in case we need to limit the size on disk
	@Value("${fileCacheCapacity}")
	private int capacity = 10; // some meaningful default
	

	public Object get(String key) {
		// read the value from cache
		// returns null if now found
		return "This is the Object Found in FileCache for: " + key;
	}

	public void put(String key, Object value) {
		// Writes the Object to a file
		// If speed is important, this can be done asynchronously
		// If durability and transaction consistency is important
		// this has to happen synchronously or we need some other feedback mechanism
	}
}
