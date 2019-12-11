package com.alpha.cache.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.cache.data.IService;

// Test service, assuming this uses on Objects of type String

@RestController
public class ServiceController {

	@Autowired
	@Qualifier("cachedService")
	private IService service;

	@GetMapping("/api/service")
	public String get(String key) {
		Object result = service.get(key);
		// If result is NULL  return HTTP Not found
		return result.toString();
		
	}
	
	@PostMapping("/api/service")
	public void put(String key, String value) {
		service.put(key, value);
	}
}
