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

	private AggregateSummary aggregateFor(Patient patient, List<Result> records) {
		return new TestResultAggregator(patient, records).aggregateSummary(patient);
	}

	private final class TestResultAggregator extends ResultAggregator {

		private Patient testPatient;
		private List<Result> testRecords;

		public TestResultAggregator(Patient patient, List<Result> records) {
			this.testPatient = patient;
			this.testRecords = records;
		}

		@Override
		protected List<Result> fetchRecordsFor(Patient patient) {
			return testRecords;
		}
	}
}