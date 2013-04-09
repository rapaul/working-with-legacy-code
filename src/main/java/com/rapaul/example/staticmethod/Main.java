package com.rapaul.example.staticmethod;

public class Main {
	
	public static void main(String... args) {
		AggregationDisplay aggregationDisplay = wireUpApp();
		System.out.println(aggregationDisplay.displayAggregationFor(new Patient("123")));
	}

	protected static AggregationDisplay wireUpApp() {
		return new AggregationDisplay(
				new ResultAggregator(
						new ManagerDelegatingResultFetcher()));
	}

}
