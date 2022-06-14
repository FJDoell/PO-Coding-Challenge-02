package com;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem statement <br>
 * Write a program that accepts sets of three numbers, and prints the
 * second-maximum number among the three.
 * 
 * @author darkm (Frederick)
 *
 */
public class Main {
	static int perLine = 3;

	public static void main(String[] args) {
		// first arg is number of 3 int lines
		int n = Integer.parseInt(args[0]);
		solution(n, args);
	}

	/**
	 * per each line n, takes args following 1 to the end
	 * of args.
	 * Args passed and per line must line up or this will explode.
	 * @param n
	 * @param args
	 */
	private static void solution(int n, String[] args) {
		int argsPos = 1;
		List<Integer> numList = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < perLine; j++) {
				numList.add(Integer.parseInt(args[argsPos]));
				argsPos++;
			}
			numList.sort(null);
			System.out.println(numList.get(1));
			numList.clear();
		}
	}

}
