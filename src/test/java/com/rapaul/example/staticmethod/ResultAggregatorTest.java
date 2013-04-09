package com.rapaul.example.staticmethod;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ResultAggregatorTest {

	private Patient patient = new Patient("123");

	@Test
	public void cantCreateAnAggregateSummaryIfNoResultsExist() throws Exception {
		fail("TODO check a suitable exception is thrown");
	}

	@Test
	public void calculatesTheMeanOfAllResults() {
		AggregateSummary aggregateSummary = aggregateFor(patient, Arrays.asList(new Result(1), new Result(2)));
		assertThat(aggregateSummary.getMean(), is(new BigDecimal(1.5)));
	}

	private AggregateSummary aggregateFor(Patient patient, List<Result> results) {
		return new TestResultAggregator(patient, results).aggregateSummary(patient);
	}

	private final class TestResultAggregator extends ResultAggregator {

		private Patient testPatient;
		private List<Result> testResults;

		public TestResultAggregator(Patient patient, List<Result> results) {
			this.testPatient = patient;
			this.testResults = results;
		}

		@Override
		protected List<Result> fetchResultsFor(Patient patient) {
			if (patient != testPatient) {
				throw new IllegalStateException("Expected a different patient, got: " + patient);
			}
			return testResults;
		}
	}
}