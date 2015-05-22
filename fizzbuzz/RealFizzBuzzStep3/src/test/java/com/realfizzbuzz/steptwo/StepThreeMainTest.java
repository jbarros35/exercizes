package com.realfizzbuzz.steptwo;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;

import com.realfizzbuzz.stepthree.StepThreeMain;

import junit.framework.TestCase;

/**
 * 
 * Test case for main class. Simulates an user input and test expected output.
 * 
 * @author JOSE CARLOS BARROS
 */
public class StepThreeMainTest extends TestCase {

	/**
	 * The expected output.
	 */
	private static final String EXPECTED_OUTPUT = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz";

	/**
	 * Test case of startCalculation in main class.
	 */
	public void testStartCalculation() {
		// Pass first and second parameters.
		ByteArrayInputStream in = new ByteArrayInputStream("1\n20".getBytes());
		System.setIn(in);
		// Create object for getting result.
		final StringWriter out = new StringWriter();
		StepThreeMain.startCalculation(in, out);
		assertEquals(
				EXPECTED_OUTPUT,
				out.toString());
	}

	public void testErrorNumbers() {
		// Pass first and second parameters.
		ByteArrayInputStream in = new ByteArrayInputStream(
				"a\nb\n1\n20".getBytes());
		System.setIn(in);
		// Create object for getting result.
		final StringWriter out = new StringWriter();
		StepThreeMain.startCalculation(in, out);
		assertEquals(
				EXPECTED_OUTPUT,
				out.toString());
	}

	public void testException() {
		// Pass first and second parameters.
		ByteArrayInputStream in = new ByteArrayInputStream(
				"a\nb\n1\n20".getBytes());
		System.setIn(in);
		boolean hasError = false;
		try {
			StepThreeMain.startCalculation(in, null);
		} catch(Exception e) {
			hasError = true;
		}
		assertTrue(hasError);
	}
}
