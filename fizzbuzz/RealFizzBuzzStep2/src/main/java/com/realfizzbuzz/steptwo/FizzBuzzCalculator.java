package com.realfizzbuzz.steptwo;

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
	 * Calculate which value correspondents to input number.
	 * @param number the value passed.
	 * @return the word calculated.
	 */
	public static String getFizzBuzzValue(final int number) {
		String wordOrNumber = null;

		if (containsThree(number)) {
			// if contains a three, overrides multiple of three.
			wordOrNumber = FizzBuzzEnum.LUCKY.getValue();
		} else {
			if (number % FIFTEEN == ZERO) {
				wordOrNumber = FizzBuzzEnum.FIZZBUZZ.getValue();
			} else if (number % FIVE == 0) {
				// for multiples of five return buzz
				wordOrNumber = FizzBuzzEnum.BUZZ.getValue();
			} else if (number % THREE == 0) {
				// those multiple of three return fizz
				wordOrNumber = FizzBuzzEnum.FIZZ.getValue();
			} else {
				// convert the number to string
				wordOrNumber = String.valueOf(number);
			}			
		}
		return wordOrNumber;
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
	
}
