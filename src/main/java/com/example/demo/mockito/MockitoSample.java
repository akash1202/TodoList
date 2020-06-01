package com.example.demo.mockito;

public class MockitoSample {
private MockitoDataService dataService;

	public MockitoSample(MockitoDataService dataService) {
	this.dataService = dataService;
}
	public int getTheGreatest(){
		int[] data=dataService.retrieveAllData();
		int greater=Integer.MIN_VALUE;
		for(int a:data) {
			if (greater<a) {
				greater=a;
			}
		}
		return greater;
	}
}





