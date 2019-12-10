package com.alpha.cache.service;

public class CachedServiceTests {

/*
 * Test 1: If cache.get return object, then call to get should not invoke get on data service
 * Test 2: If cache.get did not return object, then get should trigger invoke of get on data service
 * Test 3: If cache.get did not return object and invoke of get on data service returned an object, then the object should be put on cache
 * 
 * Test 3: Every put of an object should trigger a put on data service
 * Following test applies only if we are aggressively caching
 * Test 4: Every put of an object should trigger a put on cache following a successful put on data service
 */
}

