package com.realfizzbuzz.steptwo;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author JOSE CARLOS BARROS
 * @since 2015-03-24
 * Main class responsible for getting inputs and getting results from FizzBuzzCalculation.
 */
public class StepTwoMain {
	
	/**
	 * The main method. Get two values and calculate the fizzbuzz words.
	 * @param args program arguments are not needed.
	 */
	public static void main(String[] args) {
		startCalculation(System.in, new StringWriter());
	}

	/**
	 * Start calculation of fizzBuzzWords.
	 * @param in
	 * @param writer
	 */
	public static void startCalculation(final InputStream in, StringWriter writer) {
		System.out.println("Hello this is FizzBuzz Step Two! I hope you are glad using this program, "
				+ "let's have some fun with numbers.");
		System.out.println("FizzBuzz calculates words based on a start range and a final range, "
				+ "if you provide me valid numbers we can see some action...");
		final Scanner scan = new Scanner(in);
		boolean hasEnoughInput = false;
		while(!hasEnoughInput) {
			try {
				System.out.println("Please get me the first range:");
				final int startRange = Integer.parseInt(scan.nextLine());
				System.out.println("Fine! Please get me the final range:");
				final int finalRange = Integer.parseInt(scan.nextLine());
				System.out.println("Cool! Let's start the engines of FizzBuzzCalculation...");
				hasEnoughInput = true;
				// iterate from start to final ranges
				for (int i = startRange; i <= finalRange; i++) {
					writer.append(FizzBuzzCalculator.getFizzBuzzValue(i));
					// append a space if not finished yet
					if (i < finalRange) {
						writer.append(" ");
					}
				}
				// print the final result
				System.out.println(writer.toString());
			} catch (final NumberFormatException inputError) {
				System.out.println("I'm sorry sir but I think you gave me invalid numbers... please try again!");
			} catch (final Exception exception) {
				System.out.println("Please forgive me sir but I got an unexpected error! "
						+ "Please don't throw me in the garbage...");
				exception.printStackTrace();
			}
		}
	}
	
}
