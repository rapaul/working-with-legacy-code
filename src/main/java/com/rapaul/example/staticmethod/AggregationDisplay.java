package com.rapaul.example.staticmethod;

import java.text.DecimalFormat;

public class AggregationDisplay {
	
	private ResultAggregator resultAggregator;

	public AggregationDisplay(ResultAggregator resultAggregator) {
		this.resultAggregator = resultAggregator;
	}
	
	public String displayAggregationFor(Patient patient) {
		AggregateSummary summary = resultAggregator.aggregateSummary(patient);
		String formattedMean = new DecimalFormat("#0.##").format(summary.getMean());
		return String.format("Mean: %s, Max: %s, Min: %s", formattedMean, summary.getMaximum(), summary.getMinimum());
	}
	
}
