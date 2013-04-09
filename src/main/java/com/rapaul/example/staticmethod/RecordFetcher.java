package com.rapaul.example.staticmethod;

import java.util.List;

public class RecordFetcher {
	
	public static List<Result> getRecordsFor(Patient patient) {
		throw new IllegalStateException("Can not connect to the record database");
	}
	
}