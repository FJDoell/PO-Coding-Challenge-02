package com;

/**
 * Problem statement <br>
 * Given an alphanumeric string made up of digits and lower case Latin
 * characters only, find the sum of all the digit characters in the string.
 * 
 * @author darkm (Frederick)
 *
 */
public class Main {

	public static void main(String[] args) {
		int testCases = Integer.parseInt(args[0]);
		if (testCases >= 1) {
			for (int i = 1; i < args.length; i++) {
				solution(args[i]);
			}
		} else {
			System.out.println("Zero test cases.");
		}
	}
	
	/**
	 * Given a string, add all digits contained.
	 * @param testCase
	 * @return
	 */
	public static int solution(String testCase) {
		int result = 0;
		for(int i = 0; i < testCase.length(); i++) {
			char current = testCase.charAt(i);
			if(Character.isDigit(current)) {
				result = result + Character.getNumericValue(current);
			}
		}
		System.out.println(result);
		return result;
	}

}
