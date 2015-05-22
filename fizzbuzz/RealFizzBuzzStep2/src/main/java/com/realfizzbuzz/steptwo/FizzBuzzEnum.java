package com.realfizzbuzz.steptwo;

/**
 * 
 * @author JOSE CARLOS BARROS
 * @since 2015-03-24
 *
 */
public enum FizzBuzzEnum {

	FIZZ("fizz"), FIZZBUZZ("fizzbuzz"), BUZZ("buzz"), LUCKY("lucky");
	
	private String stringValue;
	
	FizzBuzzEnum(final String stringValue) {
		this.stringValue = stringValue;
	}
	
	public String getValue() {
		return stringValue;
	}
}
