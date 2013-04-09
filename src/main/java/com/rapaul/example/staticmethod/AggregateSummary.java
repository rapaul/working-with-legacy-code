package com.rapaul.example.staticmethod;

import java.math.BigDecimal;

public class AggregateSummary {

	private BigDecimal mean;
	private int minimum;
	private int maximum;

	public AggregateSummary(BigDecimal mean, int minimum, int maximum) {
		this.mean = mean;
		this.minimum = minimum;
		this.maximum = maximum;
	}

	public BigDecimal getMean() {
		return mean;
	}

	public int getMinimum() {
		return minimum;
	}

	public int getMaximum() {
		return maximum;
	}

}
