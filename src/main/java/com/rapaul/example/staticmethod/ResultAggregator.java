package com.rapaul.example.staticmethod;

import java.math.BigDecimal;
import java.util.List;

public class ResultAggregator {
	
	public AggregateSummary aggregateSummary(Patient patient) {
		List<Result> pendingResults = fetchResultsFor(patient);
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

	protected List<Result> fetchResultsFor(Patient patient) {
		return ResultManager.getResultsFor(patient);
	}

}
