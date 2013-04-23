package com.rapaul.example.methoddoestoomuch;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class ResultsDisplay {
	
	public static void main(String... args) {
		new ResultsDisplay().displayAggregationFor(new Patient("patient-1", "Joe Bloggs"));
	}

	public void displayAggregationFor(Patient patient) {
		List<Result> results = ResultManager.getResultsFor(patient);
		int sum = 0;
		int minimum = 0;
		int maximum = 0;
		for (Result result : results) {
			sum = result.getValue();
			if (result.getValue() < minimum) {
				minimum = result.getValue();
			}
			if (result.getValue() > maximum) {
				maximum = result.getValue();
			}
		}
		BigDecimal count = new BigDecimal(results.size());
		BigDecimal mean = new BigDecimal(sum).divide(count);
		
		System.out.println("Patient Record");
		System.out.println("======");
		System.out.println("Name:\t" + patient.getName());
		System.out.println("ID:\t" + patient.getId());
		System.out.println();
		
		String formattedMean = new DecimalFormat("#0.##").format(mean);
		System.out.println("Summary");
		System.out.println("======");
		System.out.println(String.format("Mean: %s, Max: %s, Min: %s", formattedMean, maximum, minimum));
		
		System.out.println();
		System.out.println("All results");
		System.out.println("======");
		for (Result result : results) {
			System.out.println(result.getValue());
		}
	}

}
