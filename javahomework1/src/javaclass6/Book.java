package javaclass6;

import java.util.ArrayList;
import java.util.Scanner;

import class6mgr.Manageable;

public class Book implements Manageable {
	// 자료구조 생능출판 1001 2003 천인국 공용해 하상호 0 15000
	static String bookType = "일반책";
	String name;
	String pub;
	String isbn;
	int year;
	ArrayList<String> authors = new ArrayList<>();
	int price;

	public void read(Scanner scan) {
		name = scan.next();
		pub = scan.next();
		isbn = scan.next();
		year = scan.nextInt();
		String tok;
		while (true) {
			tok = scan.next();
			if (tok.equals("0"))
				break;
			authors.add(tok);
		}
		price = scan.nextInt();
	}

	String getBookType() {
		return bookType;
	}

	public void print() {
		System.out.printf("[%s] ", getBookType());
		// 자료구조(생능출판/1001/2003년)[15000원] 저자:천인국 공용해 하상호
		System.out.printf("%s(%s/%s/%d년)[%d원] 저자:", name, pub, isbn, year, price);
		for (String a : authors)
			System.out.printf(" %s", a);
		System.out.println();
	}

	public boolean matches(String kwd) {
		// TODO Auto-generated method stub
		if (getBookType().equals(kwd))
			return true;
		if (name.contains(kwd))
			return true;
		if (pub.equals(kwd))
			return true;
		if (isbn.equals(kwd))
			return true;
		if (("" + year).equals(kwd))
			return true;
		for (String a : authors)
			if (a.contains(kwd))
				return true;
		return false;
	}
}
