package com.rapaul.example.staticmethod;

import java.io.PrintStream;

public class Main {

	public static void main(String... args) {
		main(System.out);
	}

	protected static void main(PrintStream out) {
		AggregationDisplay aggregationDisplay = new AggregationDisplay(new ResultAggregator());
		out.println(aggregationDisplay.displayAggregationFor(new Patient("123")));
	}

}
