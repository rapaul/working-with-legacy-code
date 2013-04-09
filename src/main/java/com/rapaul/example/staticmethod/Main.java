package com.rapaul.example.staticmethod;

public class Main {
	
	public static void main(String... args) {
		AggregationDisplay aggregationDisplay = new AggregationDisplay(new ResultAggregator());
		System.out.println(aggregationDisplay.displayAggregationFor(new Patient("123")));
	}

}
