package com.example.demo.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class MockitoBusinessTest {

		@Mock
		MockitoDataService dataServiceMock;
		
		@InjectMocks
		MockitoSample mockitoSample1;
	
	
		@Test //JUnit 5 library used here for testing
		public void findGreatestFromAllDataOne() {
			//MockitoDataService dataServiceMock=mock(MockitoDataService.class);
			when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25,23,12,2,11,9});
			//MockitoSample mockitoSample=new MockitoSample(dataServiceMock);
			assertEquals(25,mockitoSample1.getTheGreatest());
		}
		
		@Test
		public void findGreatestFromAllDataTwo() {
			//MockitoDataService dataServiceMock=mock(MockitoDataService.class);
			when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{12});
			//MockitoSample mockitoSample=new MockitoSample(dataServiceMock);
			assertEquals(12,mockitoSample1.getTheGreatest());
		}
}