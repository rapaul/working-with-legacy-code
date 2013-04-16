package com.rapaul.example.staticmethod;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class MainTest {

	@Test
	public void aggregatesResults() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Main.main(new PrintStream(outputStream));
		assertThat(outputStream.toString(), is("Mean: 1.5, Max: 2, Min: 1\n"));
	}

}
