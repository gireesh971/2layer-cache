package com.alpha.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("memoryCache")
public class MemoryCache implements ICache {

	@Value("${memoryCacheCapacity}")
	private int capacity = 10; // some meaningful default
	
	@Autowired
	@Qualifier("fileCache")
	private ICache cache;
	
	public Object get(String key) {
		// Returns value from cache if found
		// Will be nice to have some logic to keep track of usage (last used time etc)
		// so that when full, least used item can be evicted
		// if Object is not found locally, it is fetched from file cache
		
		// if (this.contain(key))
		//	return value
		// else
		//	check the file cache and return
		return null;
	}

	public void put(String key, Object value) {
		// Checks capacity, if full will evict the least used
		// Will have some logic to assign this as recent data
		// so that it doesn't get evicted soon
		// Some kind of synchronization necessary - so that multiple threads
		// are taken care of
		
		// The evicted item can be be stored to file Cache
		// There is also a question of whether we should actively copy every added Object to
		// File cache. This may help when process crashes and memory gets wiped out
	}

}
