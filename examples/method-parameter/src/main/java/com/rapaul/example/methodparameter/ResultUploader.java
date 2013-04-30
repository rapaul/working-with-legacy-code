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

	public void upload(ResultInputSource source) {
		if (source.getValues() == null) {
			return;
		}

		Collection<Result> results = new LinkedList<Result>();
		for (String result : source.getValues()) {
			results.add(new Result(source.getPatientId(), result));
		}

		repository.store(results, clock.now());
	}

	public void upload(HttpServletRequest request) {
		upload(new HttpServletRequestResultInputSource(request));
	}

}
