package com.app.logical;

public class PyramidDemo {

	public static void main(String[] args) {
		int rows = 5;

		System.out.println("\n1. Half Pyramid\n");
		for (int i = 0; i < rows; i++) {

			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}

			System.out.println("");
		}
		 System.out.println("\n2. Full Pyramid\n");
	        for (int i = 0; i < rows; i++) {

	            for (int j = 0; j < rows - i; j++) {
	                System.out.print(" ");
	            }

	            for (int k = 0; k <= i; k++) {
	                System.out.print("* ");
	            }

	            System.out.println("");
	 
	        }
	}
	

}
