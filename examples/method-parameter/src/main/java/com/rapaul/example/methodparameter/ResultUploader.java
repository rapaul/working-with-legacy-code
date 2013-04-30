package com.rapaul.example.methodparameter;

import java.util.Collection;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

public class ResultUploader {

	private ResultRepository repository;
	private Clock clock;

	public ResultUploader(ResultRepository repository, Clock clock) {
		this.repository = repository;
		this.clock = clock;
	}

	public void upload(HttpServletRequest request) {
		String patientId = request.getParameter("patientId");
		String[] resultParameters = request.getParameterValues("results");

		Collection<Result> results = new LinkedList<Result>();
		for (String result : resultParameters) {
			results.add(new Result(patientId, result));
		}

		repository.store(results, clock.now());
	}
}
