package com.rapaul.example.staticmethod;

import java.math.BigDecimal;
import java.util.List;

public class ResultAggregator {
	
	private final ResultFetcher resultFetcher;

	public ResultAggregator(ResultFetcher resultFetcher) {
		this.resultFetcher = resultFetcher;
	}
	
	public AggregateSummary aggregateSummary(Patient patient) {
		List<Result> pendingResults = resultFetcher.getResultsFor(patient);
		int sum = 0;
		int minimum = 0;
		int maximum = 0;
		for (Result result : pendingResults) {
			sum = result.getValue();
			if (result.getValue() < minimum) {
				minimum = result.getValue();
			}
			if (result.getValue() > maximum) {
				maximum = result.getValue();
			}
		}
		BigDecimal count = new BigDecimal(pendingResults.size());
		BigDecimal mean = new BigDecimal(sum).divide(count);
		return new AggregateSummary(mean, minimum, maximum);
	}

}
