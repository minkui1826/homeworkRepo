package javahomework4;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
	String name;
	String pwd;
	int point;
	ArrayList<Item> basket = new ArrayList<>();
	
	User(String name) {
		this.name = name;
	}
	
	public void read(Scanner scan, Store store) {
		int itemNum;
		Item it = null;
		pwd = scan.next();
		point = scan.nextInt();
		while(true) {
			itemNum = scan.nextInt();
			if(itemNum==0) break;
			it = store.findItem(itemNum);
			basket.add(it);
			point += it.price/100;
		}
	}
	
	public int calcTotalPrice() {
		int totalPrice = 0;
		for(Item it : basket) {
			totalPrice += it.price;
		}
		return totalPrice;
	}
	
	public void print() {
		System.out.printf("[%s] 총구매 %d건 %d원 (%d점)\n"
				,name,basket.size(),calcTotalPrice(),point);
		for(Item it : basket) {
			System.out.printf(" %s",it.name);
		}
		System.out.println();
	}
	
	public boolean matches(String kwd) {
		if(name.equals(kwd)) return true;
		return false;
	}
	
	public boolean haveItem(int num) {
		for(Item item : basket) {
			if(item.num == num) return true;
		}
		return false;
	}
}
