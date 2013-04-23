package com.rapaul.example.staticmethod;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;

public class ResultAggregatorTest {

	private Patient patient = new Patient("123");
	private ResultAggregator aggregator = new ResultAggregator();

	@Test
	public void cantCreateAnAggregateSummaryIfNoResultsExist() throws Exception {
		fail("TODO check a suitable exception is thrown");
	}
	
	@Test
	public void calculatesTheMeanOfAllResults() {
		// TODO where did we set up the data?
		AggregateSummary aggregateSummary = aggregator.aggregateSummary(patient);
		assertThat(aggregateSummary.getMean(), is(new BigDecimal(1)));
	}

}