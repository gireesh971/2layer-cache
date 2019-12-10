package com.alpha.cache.service;

public class MemoryCacheTests {

/*
 * Test 1: Given Object is put in cache and is not evicted, a call to get should return the object
 * Test 2: Given Object is put in cache and is not evicted, a call to get should not invoke a get on file cache
 * Test 3: Given Object is evicted, when a get is invoked, a get is invoked on file cache
 * Test 4: Given file cache return null, get should return null
 * 
 * Test 5: Given Object is put right now, it should not get evicted before others
 * Assuming we need durable cache
 * Test 6: Given an object is put in cache, it is put into the file cache as well
 * Test 7: Given memory capacity is full, when a put is called, the least used object is evicted
 */

}
