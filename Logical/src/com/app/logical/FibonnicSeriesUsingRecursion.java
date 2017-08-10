package com.app.logical;

public class FibonnicSeriesUsingRecursion {

	public static void main(String[] args) {
		rec(10);
	}

	public static void rec(int count) {
		int first = 0;
		int second = 1;
		int sum = 0;
		
		System.out.println(first);
		System.out.println(second);
		for (int i = 0; i <= count; i++) {
			sum = first + second;
			first = second;
			second = sum;
			System.out.println(sum);
		}

	}

}
