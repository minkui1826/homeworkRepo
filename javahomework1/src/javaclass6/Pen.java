package javaclass6;

import java.util.Scanner;

import class6mgr.Manageable;

public class Pen implements Manageable {
	String name;
	String type;
	int price;

	public void read(Scanner scan) {
		// TODO Auto-generated method stub
		name = scan.next();
		type = scan.next();
		price = scan.nextInt();
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.printf("[펜] %s (%smm) %d원\n", name, type, price);
	}

	public boolean matches(String kwd) {
		// TODO Auto-generated method stub
		if (name.contains(kwd))
			return true;
		if (type.equals(kwd))
			return true;
		if (price == Integer.parseInt(kwd))
			return true;
		return false;
	}
}
