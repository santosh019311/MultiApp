package com.app.pattern;

import java.util.Scanner;

public class Pattern2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the input : ");
		int input = scn.nextInt();
		for (int row = 1; row <= input; row++) {
			for (int col = input; col >= row; col--) {
				System.out.print("*");
				// System.out.print(col);
			} // for
			System.out.println();
		} // for
	}// main
}// class
