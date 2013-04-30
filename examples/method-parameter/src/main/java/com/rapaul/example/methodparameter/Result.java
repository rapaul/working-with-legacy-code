package com.rapaul.example.methodparameter;

public class Result {

	private String value;
	private String patientId;

	public Result(String patientId, String value) {
		this.patientId = patientId;
		this.value = value;
	}

	public String getPatientId() {
		return patientId;
	}

	public String getValue() {
		return value;
	}

	// Generated
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((patientId == null) ? 0 : patientId.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	// Generated
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		if (patientId == null) {
			if (other.patientId != null)
				return false;
		} else if (!patientId.equals(other.patientId))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
