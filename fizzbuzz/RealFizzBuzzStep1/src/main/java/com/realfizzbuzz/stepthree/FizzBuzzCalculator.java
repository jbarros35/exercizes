package com.realfizzbuzz.stepthree;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Class responsible for calculating fizz buzz based on numbers input by user.
 * @author JOSE CARLOS BARROS
 * @since 2015-03-24
 * 
 */
public class FizzBuzzCalculator {

	/**
	 * Number zero.
	 */
	private static final int ZERO = 0;

	/**
	 * String representation of three.
	 */
	private static final String S_THREE = "3";

	/**
	 * Number 15.
	 */
	private static final int FIFTEEN = 15;
	
	/**
	 * Number 5.
	 */
	private static final int FIVE = 5;
	
	/**
	 * Number 3.
	 */
	private static final int THREE = 3;
	
	/**
	 * Map for storing the count of values found.
	 */
	private Map<FizzBuzzEnum, Integer> countMap = new HashMap<FizzBuzzEnum, Integer>();
	
	/**
	 * Calculate which value correspondents to input number and append to table for counting.
	 * Static anymore, we store inside this class how many times was find the values.
	 * @param number the value passed.
	 * @return the word calculated.
	 */
	public FizzBuzzEnum appendFizzBuzzValue(final int number) {
		FizzBuzzEnum wordOrNumber = null;

		if (containsThree(number)) {
			// if contains a three, overrides multiple of three.
			wordOrNumber = FizzBuzzEnum.LUCKY;
		} else {
			if (number % FIFTEEN == ZERO) {
				wordOrNumber = FizzBuzzEnum.FIZZBUZZ;
			} else if (number % FIVE == ZERO) {
				// for multiples of five return buzz
				wordOrNumber = FizzBuzzEnum.BUZZ;
			} else if (number % THREE == ZERO) {
				// those multiple of three return fizz
				wordOrNumber = FizzBuzzEnum.FIZZ;
			} else {
				// convert the number to string
				wordOrNumber = FizzBuzzEnum.INTEGER;
			}
		}
		updateCount(wordOrNumber);
		return wordOrNumber;
	}

	/**
	 * Update the map count.
	 * @param wordOrNumber word found.
	 */
	private void updateCount(final FizzBuzzEnum wordOrNumber) {
		Integer count = countMap.get(wordOrNumber);
		if (count != null) {
			// sum 1 for word count
			count += 1;
		} else {
			// start the count for word found
			count = 1;
		}
		countMap.put(wordOrNumber, count);
	}

	/**
	 * Check if number has some three on its composition.
	 * If the number contains a three you must output the text 'lucky'. 
	 * This overrides any existing behaviour.
	 * @param number the input number.
	 * @return if has or not a three.
	 */
	private static boolean containsThree(final int number) {
		final String stringNumber = String.valueOf(number);
		return stringNumber.contains(S_THREE);
	}

	/**
	 * Get the count map.
	 * @return count map of words.
	 */
	public Map<FizzBuzzEnum, Integer> getCountMap() {
		return countMap;
	}
	
	
}
