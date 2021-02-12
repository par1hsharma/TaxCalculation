package EffectiveCost;

import java.util.Scanner;

public class TotalCost {

	String name;
	String type;
	double price;
	double quantity;

	public void input() throws Exception {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter Item name: ");
		this.name = scan.nextLine();

		if (this.name.isEmpty()) {
			throw new Exception("name cannot be empty");
		}
		System.out.println("Enter Item type(raw/manufactured/imported): ");
		this.type = scan.nextLine();

		if (this.type.isEmpty()) {
			throw new Exception("Type cannot be empty");
		}

		if (!this.type.equals("raw") && !this.type.equals("manufactured") && !this.type.equals("imported")) {
			throw new Exception("Invalid type");
		}
		System.out.println("Enter Item price: ");
		this.price = scan.nextInt();

		if (this.price == 0 && this.price < 0) {
			throw new Exception("Enter correct value");
		}
		System.out.println("Enter Item quantity: ");
		this.quantity = scan.nextInt();

		if (this.quantity == 0 && this.price < 0) {
			throw new Exception("Quantity cannot be 0");
		}

	}

	public double TaxCalulation(String s) {

		double tax = 0;

		if (s.equals("raw")) {
			tax = 0.125 * price;

		}

		if (s.equals("manufactured")) {
			tax = (0.125 * price) + (0.02 * (price + 0.125 * price));

		}
		if (s.equals("imported")) {
			tax = 0.1 * price;

			if (tax <= 100) {
				tax += 5;

			} else if (tax >= 100 && tax <= 200) {
				tax += 10;

			} else
				tax += 0.05 * (tax + price);

		}
		return tax;
	}

	public double FinalPrice(String s) {

		double fprice = TaxCalulation(s);
		double ftax = fprice + price;

		return ftax;

	}

	public void display() {
		System.out.println("--------------------------------------------");

		System.out.println("Name: " + this.name);
		System.out.println("Price: " + this.price);
		System.out.println("Tax: " + TaxCalulation(type));
		System.out.println("FinalPrice: " + FinalPrice(type));
		System.out.println("--------------------------------------------");
	}

}
