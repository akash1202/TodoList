package com.example.demo.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class StubBusinessTest {

	@Test //JUnit 5 library used here for testing
	public void findGreatestFromAllData() {
		MockitoSample mockitoSample=new MockitoSample(new DataServiceStub());
		assertEquals(25,mockitoSample.getTheGreatest());
	}
}

class DataServiceStub implements MockitoDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {25,23,5,20,2,10};
	}

}
