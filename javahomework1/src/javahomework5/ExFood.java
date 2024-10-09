package javahomework5;

import java.util.Scanner;

public class ExFood extends Food {
	int amount;
	String perunit;
	
	@Override
	void read(Scanner scan) {
		super.read(scan);
		amount = scan.nextInt();
		perunit = scan.next();
	}
	
	@Override
	void printNoLn() {
		super.printNoLn();
		System.out.format(" %d%s", amount, perunit);
	}
	
	@Override
	int getKcal(int n, String u) {
		if (u.equals(perunit))
			return cal*n/amount;
		else return cal*n;
	}
	
	@Override
	void printDetail(int n, String u) {
		System.out.printf("(%d%s) -> %dkcal*%d/%d%s=%dkcal",
				amount, perunit, cal, n, amount,perunit, getKcal(n,u));
	}
}
