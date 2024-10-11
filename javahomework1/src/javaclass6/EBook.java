package javaclass6;

import java.util.Scanner;

public class EBook extends Book {
	static String bookType = "전자책";
	String url;
	String format;
	@Override
	public void read(Scanner scan) {
		super.read(scan);
		url = scan.next();
		format = scan.next();
	}
	@Override
	public void print() {
		super.print();
		System.out.printf("\t%s [%s]\n", url, format);
	}
	@Override
	String getBookType() {
		return bookType;
	}
	@Override
	public boolean matches(String kwd) {
		if(super.matches(kwd)) return true;
		if(url.contains(kwd)) return true;
		if(format.equals(kwd)) return true;
		return false;
	}
}
