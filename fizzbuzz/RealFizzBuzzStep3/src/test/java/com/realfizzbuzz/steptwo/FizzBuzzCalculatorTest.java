package com.realfizzbuzz.steptwo;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.realfizzbuzz.stepthree.FizzBuzzCalculator;
import com.realfizzbuzz.stepthree.FizzBuzzEnum;

/**
 * Unit test for simple FizzBuzzCalculator.
 */
public class FizzBuzzCalculatorTest extends TestCase {
	
	/**
	 * Create the test case.
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
		FizzBuzzCalculator calculator = new FizzBuzzCalculator();
		for (int number = 1; number <= 20; number++) {
			final FizzBuzzEnum fizzEnum = calculator.appendFizzBuzzValue(number);
			String word = fizzEnum.getValue();
			if (String.valueOf(number).contains("3")) {
				// those multiple of three return fizz
				assertEquals(FizzBuzzEnum.LUCKY.getValue(), word);
			} else {
				if (number % 15 == 0) {
					assertEquals(FizzBuzzEnum.FIZZBUZZ.getValue(), word);
				} else if (number % 5 == 0) {
					// for multiples of five return buzz
					assertEquals(FizzBuzzEnum.BUZZ.getValue(), word);
				} else if (number % 3 == 0) {
					// those multiple of three return fizz
					assertEquals(FizzBuzzEnum.FIZZ.getValue(), word);
				} else {
					// convert the number to string
					assertEquals(FizzBuzzEnum.INTEGER.getValue(), word);
				}
			}	
			
		}
		// assert the final reporting
		final Map<FizzBuzzEnum, Integer> reporting = new HashMap<FizzBuzzEnum, Integer>();
		reporting.put(FizzBuzzEnum.FIZZ, 4);
		reporting.put(FizzBuzzEnum.INTEGER, 10);
		reporting.put(FizzBuzzEnum.FIZZBUZZ, 1);
		reporting.put(FizzBuzzEnum.BUZZ, 3);
		reporting.put(FizzBuzzEnum.LUCKY, 2);
		assertEquals(reporting, calculator.getCountMap());
	}
}
