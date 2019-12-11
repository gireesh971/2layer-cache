package com.alpha.cache.web;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.alpha.cache.data.IService;

@RunWith(MockitoJUnitRunner.class)
public class ServiceControllerTests {

/*
 * Test1: If the dummy service return "x", the get should return "x"
 * Test2: If the dummy service return null, the get service return HTTP not found
 * 
 * Test3: Call to put invoke put on dummy service
 */
	
	@Mock(name = "cachedService")
    IService cachedService;

    @InjectMocks
	ServiceController controller;
    
	@Before
	public void initialiseBeforeTest() {
		MockitoAnnotations.initMocks(this);
		Mockito.when(cachedService.get("key")).thenReturn("expected result");
	}

    @Test
    public void CallingGetOnControllerInvokesGetOnService() {
    	controller.get("key");
    	verify(cachedService, times(1)).get("key");
    }

    @Test
    public void CallingGetReturnsTheTheValueFroundInCache() {
    	String result = controller.get("key").toString();
    	assertEquals(result, "expected result");
    }
}
