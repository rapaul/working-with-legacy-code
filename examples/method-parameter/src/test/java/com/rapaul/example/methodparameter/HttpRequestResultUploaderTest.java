package com.rapaul.example.methodparameter;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

public class HttpRequestResultUploaderTest {

	private ResultRepository repository = mock(ResultRepository.class);
	private HttpServletRequest request = mock(HttpServletRequest.class);
	private Clock clock = new FixedTimeClock(new Date());

	private ResultUploader uploader = new ResultUploader(repository, clock);

	@Test
	public void storesSingleResult() {
		given(request.getParameter("patientId")).willReturn("patient-id-123");
		given(request.getParameterValues("results")).willReturn(new String[] { "value1" });

		uploader.upload(request);

		verify(repository).store(Arrays.asList(new Result("patient-id-123", "value1")), clock.now());
	}

	@Test
	public void submissionsWithoutResultsAreIgnored() throws Exception {
		given(request.getParameter("patientId")).willReturn("patient-id-123");

		uploader.upload(request);

		verifyZeroInteractions(repository);
	}

}
