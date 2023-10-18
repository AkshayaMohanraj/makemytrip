package com.makemytrip.baseclass;

public class Pyramid {

	public static void main(String[] args) {

		int n = 5;

		for (int i = 1; i <= n; i++) { //2

			for (int j = n; j >= i; j--) {  //3
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) { //1
				System.out.print(j);
			}
			for (int j = i-1; j >= 1; j--) { //4
				System.out.print(j);
			}
			System.out.println();

		}
	}

}
