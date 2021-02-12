package EffectiveCost;

import java.util.Scanner;

public class TaxClient {

	public static void main(String[] args) throws Exception {

		Scanner s = new Scanner(System.in);
		TotalCost tc = new TotalCost();

		System.out.println("Get started(y/n): ");
		String ch = s.nextLine();

		while ("y".equals(ch)) {

			tc.input();
			tc.display();

			System.out.println("Do you want to continue(y/n): ");
			ch = s.nextLine();

		}
		System.out.println("Thanks for using this program desigend by me");

	}
}