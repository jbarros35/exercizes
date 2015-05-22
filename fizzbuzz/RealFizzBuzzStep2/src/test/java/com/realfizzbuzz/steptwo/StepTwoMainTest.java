package com.realfizzbuzz.steptwo;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;

import com.realfizzbuzz.steptwo.StepTwoMain;

import junit.framework.TestCase;

/**
 * 
 * Test case for main class. Simulates an user input and test expected output.
 * @author JOSE CARLOS BARROS
 */
public class StepTwoMainTest extends TestCase {

	/**
	 * Test case of startCalculation in main class.
	 */
	public void testStartCalculation() {
		// Pass first and second parameters.
		ByteArrayInputStream in = new ByteArrayInputStream("1\n20".getBytes());
		System.setIn(in);
		// Create object for getting result.
		final StringWriter out = new StringWriter();
		StepTwoMain.startCalculation(in, out);
		assertEquals("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz", out.toString());
	}
	
	public void testErrorNumbers() {
		// Pass first and second parameters.
		ByteArrayInputStream in = new ByteArrayInputStream("a\nb\n1\n20".getBytes());
		System.setIn(in);
		// Create object for getting result.
		final StringWriter out = new StringWriter();
		StepTwoMain.startCalculation(in, out);
		assertEquals(
				"1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz",
				out.toString());
	}
}
