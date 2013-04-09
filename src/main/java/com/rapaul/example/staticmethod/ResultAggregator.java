package com.rapaul.example.staticmethod;

import java.math.BigDecimal;
import java.util.List;

public class ResultAggregator {
	
	public AggregateSummary aggregateSummary(Patient patient) {
		List<Result> pendingRecords = fetchRecordsFor(patient);
		int sum = 0;
		int minimum = 0;
		int maximum = 0;
		for (Result record : pendingRecords) {
			sum = record.getValue();
			if (record.getValue() < minimum) {
				minimum = record.getValue();
			}
			if (record.getValue() > maximum) {
				maximum = record.getValue();
			}
		}
		BigDecimal count = new BigDecimal(pendingRecords.size());
		BigDecimal mean = new BigDecimal(sum).divide(count);
		return new AggregateSummary(mean, minimum, maximum);
	}

	protected List<Result> fetchRecordsFor(Patient patient) {
		return RecordFetcher.getRecordsFor(patient);
	}

}
