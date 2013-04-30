package com.rapaul.example.methodparameter;

import javax.servlet.http.HttpServletRequest;

public class HttpServletRequestResultInputSource implements ResultInputSource {

	private HttpServletRequest request;

	public HttpServletRequestResultInputSource(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public String getPatientId() {
		return request.getParameter("patientId");
	}

	@Override
	public String[] getValues() {
		return request.getParameterValues("results");
	}

}
