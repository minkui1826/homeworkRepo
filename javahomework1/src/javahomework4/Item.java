package javahomework4;

import java.util.Scanner;


public class Item {
	int num;
	String code;
	String name;
	int price;
	
	Item(int num, String code) {
		this.num = num;
		this.code = code;
	}
	
	public void read(Scanner scan) {
		name = scan.next();
		price = scan.nextInt();
	}
	
	public void print() {
		System.out.printf("[%d] %s %s (%d원)\n"
				,num,code,name,price);
	}
	
	public boolean matches(String kwd) {
		if((""+num).equals(kwd)) return true;
		if(code.equals(kwd)) return true;
		if(name.contains(kwd)) return true;
		return false;
	}

}
