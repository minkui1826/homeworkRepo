package javahomework5;

import java.util.Scanner;

public class Food {
	String type;
	String name;
	String unit;
	int cal;

	void read(Scanner scan) {
		type = scan.next();
		name = scan.next();
		unit = scan.next();
		cal = scan.nextInt();
	}

	void printNoLn() {
		// 빵-샌드위치 (468kcal/개)
		System.out.format("%s-%s (%dkcal/%s)", type, name, cal, unit);
	}

	void print() {
		printNoLn();
		System.out.println();
	}

	void printEat(int n, String u) {
		// 우유 100ml(0kcal) - 125kcal/1개
		System.out.format("%s %d%s(%dkcal)", name, n, u, getKcal(n, u));
		System.out.format(" - %dkcal/%d%s", cal, 1, unit);
		printDetail(n, u);
		System.out.println();
	}
	void printDetail(int n, String u) {}

	int getKcal(int n, String u) {
		return n * cal;
	}

	public boolean matches(String name2) {
		// TODO Auto-generated method stub
		if (name.equals(name2))
			return true;
		return false;
	}
}