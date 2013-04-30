package com.rapaul.example.methodparameter;

import java.util.Date;

public class FixedTimeClock implements Clock {

	private Date fixedDate;

	public FixedTimeClock(Date fixedDate) {
		this.fixedDate = fixedDate;
	}

	@Override
	public Date now() {
		return fixedDate;
	}

}
