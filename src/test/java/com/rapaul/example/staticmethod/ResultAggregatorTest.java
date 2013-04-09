package com.rapaul.example.staticmethod;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

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
		ResultFetcher resultFetcher = mock(ResultFetcher.class);
		given(resultFetcher.getResultsFor(patient)).willReturn(results);
		return new ResultAggregator(resultFetcher).aggregateSummary(patient);
	}
}