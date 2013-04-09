package com.rapaul.example.staticmethod;

import java.util.List;

public class ManagerDelegatingResultFetcher implements ResultFetcher {

	public List<Result> getResultsFor(Patient patient) {
		return ResultManager.getResultsFor(patient);
	}

}
