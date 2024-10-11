package javaclass6;

import java.util.Scanner;

import class6mgr.Manageable;

public class Tissue implements Manageable {
	String name;
	int amount;
	int price;

	public void read(Scanner scan) {
		// TODO Auto-generated method stub
		name = scan.next();
		amount = scan.nextInt();
		price = scan.nextInt();
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.printf("[티슈] %s (%d장) [%d원]\n", name, amount, price);
	}

	public boolean matches(String kwd) {
		// TODO Auto-generated method stub
		if (name.contains(kwd))
			return true;
		if (amount == Integer.parseInt(kwd))
			return true;
		if (price == Integer.parseInt(kwd))
			return true;
		return false;
	}

}
