package com.realfizzbuzz.steptwo;

import com.realfizzbuzz.steptwo.FizzBuzzCalculator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple FizzBuzzCalculator.
 */
public class FizzBuzzCalculatorTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public FizzBuzzCalculatorTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(FizzBuzzCalculatorTest.class);
	}

	/**
	 * Test ranges from 1-20.
	 */
	public void testgetFizzBuzzValue() {
		for (int number = 1; number <= 20; number++) {
			final String word = FizzBuzzCalculator.getFizzBuzzValue(number);
			if (String.valueOf(number).contains("3")) {
				// those multiple of three return fizz
				assertEquals("lucky", word);
			} else {
				if (number % 15 == 0) {
					assertEquals("fizzbuzz", word);
				} else if (number % 5 == 0) {
					// for multiples of five return buzz
					assertEquals("buzz", word);
				} else if (number % 3 == 0) {
					// those multiple of three return fizz
					assertEquals("fizz", word);
				} else {
					// convert the number to string
					final String wordOrNumber = String.valueOf(number);
					assertEquals(wordOrNumber, word);
				}
			}	
			
		}
		
		
	}
}
