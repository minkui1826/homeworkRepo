package javaclass6;

import java.util.Scanner;

import class6mgr.Factory;
import class6mgr.Manageable;
import class6mgr.Manager;


public class Bookstore extends Manager implements Factory {
	Scanner scan = new Scanner(System.in);

	void mymain() {
		// TODO Auto-generated method stub
		readAll("book4.txt", this);
		printAll();
		search(scan);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bookstore store = new Bookstore();
		store.mymain();
	}

	public Manageable create(Scanner filein) {
		int type = filein.nextInt();
		Manageable m = null;
		switch (type) {
		case 1:
			m = new Book();
			break;
		case 2:
			m = new EBook();
			break;
		case 3:
			m = new ABook();
			break;
		case 4:
			m = new Pen();
			break;
		case 5:
			m = new Tissue();
			break;
		}
		return m;
	}
}
