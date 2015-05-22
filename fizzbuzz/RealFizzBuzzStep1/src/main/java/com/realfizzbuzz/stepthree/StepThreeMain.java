package com.realfizzbuzz.stepthree;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * @author JOSE CARLOS BARROS
 * @since 2015-03-24
 * Main class responsible for getting inputs and getting results from FizzBuzzCalculation step 3.
 * 
 */
public class StepThreeMain {
	
	/**
	 * Colon constant.
	 */
	private static final String COLON = ":";
	/**
	 * Space for separating values.
	 */
	private static final String SPACE = " ";

	/**
	 * The main method. Get two values and calculate the fizzbuzz words.
	 * @param args program arguments are not needed.
	 */
	public static void main(String[] args) {
		try {
			startCalculation(System.in, new StringWriter());
		} catch (final Exception exception) {
			System.out.println("Please forgive me sir but I got an unexpected error! "
					+ "Please don't throw me in the recicle folder, see logs bellow...");
			exception.printStackTrace();
		}
	}

	/**
	 * Start calculation of fizzBuzzWords.
	 * @param in inputstream for reading values.
	 * @param writer output for storing values.
	 */
	public static void startCalculation(final InputStream in, final StringWriter writer) {
		System.out.println("Hello this is FizzBuzz Step Three! I hope you are glad using this program, "
				+ "let's have some fun with numbers.");
		System.out.println("FizzBuzz calculates words based on a start range and a final range, "
				+ "if you provide me valid numbers we can see some action...");
		final Scanner scan = new Scanner(in);
		boolean hasEnoughInput = false;
		while (!hasEnoughInput) {
			try {
				System.out.println("Please get me the first range:");
				final int startRange = Integer.parseInt(scan.nextLine());
				System.out.println("Fine! Please get me the final range:");
				final int finalRange = Integer.parseInt(scan.nextLine());
				System.out.println("Cool! Let's start the engines of FizzBuzzCalculation...");
				hasEnoughInput = true;
				final FizzBuzzCalculator calculator = new FizzBuzzCalculator();
				// iterate from start to final ranges
				for (int i = startRange; i <= finalRange; i++) {
					final FizzBuzzEnum word = calculator.appendFizzBuzzValue(i);
					if (word.equals(FizzBuzzEnum.INTEGER)) {
						writer.append(String.valueOf(i));
					} else {
						writer.append(word.getValue());	
					}
					
					// append a space if not finished yet
					if (i < finalRange) {
						writer.append(SPACE);
					}
				}
				// print the final result
				System.out.println(writer.toString());
				// print reporting
				printCountMap(calculator.getCountMap());
			} catch (final NumberFormatException inputError) {
				System.out.println("I'm sorry sir but I think you gave me invalid numbers... "
						+ "please try again!");
			}
		}
	}

	/**
	 * Print the count report in console.
	 * Follow the order proposed by the exercise.
	 * @param countMap the count map of words.
	 */
	private static void printCountMap(final Map<FizzBuzzEnum, Integer> countMap) {
		System.out.println(FizzBuzzEnum.FIZZ.getValue() + COLON + SPACE + countMap.get(FizzBuzzEnum.FIZZ));
		System.out.println(FizzBuzzEnum.BUZZ.getValue() + COLON + SPACE + countMap.get(FizzBuzzEnum.BUZZ));
		System.out.println(FizzBuzzEnum.FIZZBUZZ.getValue() + COLON 
				+ SPACE + countMap.get(FizzBuzzEnum.FIZZBUZZ));
		System.out.println(FizzBuzzEnum.LUCKY.getValue() + COLON + SPACE + countMap.get(FizzBuzzEnum.LUCKY));
		System.out.println(FizzBuzzEnum.INTEGER.getValue() + COLON 
				+ SPACE + countMap.get(FizzBuzzEnum.INTEGER));
	}
	
}
