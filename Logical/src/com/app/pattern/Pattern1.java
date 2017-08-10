package com.app.pattern;

import java.util.Scanner;

class  Pattern1{
	public static void main(String[] args){
		Scanner scn=new Scanner(System.in);
		System.out.print("Enter the input : ");
		int input=scn.nextInt();
		
		for(int row=1;row<=input;row++){
		
			for (int col=1;col<=row;col++)
			{
		//System.out.print(col);
			System.out.print("*");
			}//for
			System.out.println( );
		}//for
	}//main

}
