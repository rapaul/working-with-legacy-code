package com.rapaul.example.staticmethod;

import java.util.Arrays;
import java.util.List;

public class ResultManager {

	public static List<Result> getResultsFor(Patient patient) {
		simulateNastySlowIntegrationTest();
		return Arrays.asList(new Result(1), new Result(2));
	}

	private static void simulateNastySlowIntegrationTest() {
		sleepFor10Seconds();
		System.out.println("Time to go make a cup of tea!");
		sleepFor10Seconds();
	}

	private static void sleepFor10Seconds() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) { }
	}

}