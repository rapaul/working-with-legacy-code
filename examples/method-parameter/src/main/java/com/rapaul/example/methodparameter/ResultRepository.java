package com.rapaul.example.methodparameter;

import java.util.Collection;
import java.util.Date;

public interface ResultRepository {

	void store(Collection<Result> results, Date submissionDate);

}
