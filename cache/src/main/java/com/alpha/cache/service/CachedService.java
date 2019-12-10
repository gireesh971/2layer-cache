package com.alpha.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.alpha.cache.data.IService;

@Component("cachedService")
public class CachedService implements IService {
	
	@Autowired
	@Qualifier("dummyDataService")
	private IService service;
	
	@Autowired
	@Qualifier("memoryCache")
	private ICache cache;

	public Object get(String key) {
		// 1. Check if present in cache,
		// 2. if not fetch from data service and actively cache
		// 3. Synchronization can be done for the operation #2
		// 4. These are optimization that goes along with the synchronization characteristics of cache
		Object result = cache.get(key);
		{
			// synchronize on cache
			if (result == null) {
				result = service.get(key);
				if (result != null) {
					cache.put(key, result);
				}
			}
		}
		return result;
	}

	public void put(String key, Object value) {
		// Saves the data using the service
		service.put(key, value);
		// Error handling is an interesting question here.
		// Should we aggressively cache the data gets "put" always? This makes sense only if this
		// data has good chance of read immediately after store.
		// If that is the case we should store the data in cache
		cache.put(key, value);
		// Placing the value in cache makes sense only if the data service is not expected
		// to modify the Object in some form. e.g. inserting the value of primary key on save
		// If the object can be updated in some form, object should not be added to cache here
	}
}
