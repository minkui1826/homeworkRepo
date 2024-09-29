package javahomework4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Store {
	static ArrayList<Item> itemList = new ArrayList<>();
	static ArrayList<User> userList = new ArrayList<>();
	Scanner scan = new Scanner(System.in);

	public void run() {
		readAllItems();
		readAllUsers();
		countSoldItem();
		menu();
	}

	public void menu() {
		int menu;
		while (true) {
			System.out.printf("\n(1) 상품출력 (2) 사용자출력 (3) 상품검색 (4) 사용자검색\n" + "(5) 상품으로사용자검색 (6) 상품별판매현황 (7) 같이판매된상품\n"
					+ "(0) 종료 => ");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				printAllItems();
				break;
			case 2:
				printAllUsers();
				break;
			case 3:
				searchItem();
				break;
			case 4:
				searchUser();
				break;
			case 5:
				searchUserWithItem();
				break;
			case 6:
				itemSold();
				break;
			case 7:
				itemSoldTogether();
				break;
			case 0:
				return;
			}
		}
	}

	public void readAllItems() {
		int cnt = 1;
		String code;
		while (true) {
			code = scan.next();
			if (code.equals("0"))
				break;
			Item it = new Item(cnt++, code);
			it.read(scan);
			itemList.add(it);
		}
	}

	public void printAllItems() {
		for (Item it : itemList) {
			it.print();
		}
	}

	public void printAllUsers() {
		for (User user : userList) {
			user.print();
		}
	}

	public void readAllUsers() {
		String name;
		while (true) {
			name = scan.next();
			if (name.equals("0"))
				break;
			User user = new User(name);
			user.read(scan, this);
			userList.add(user);
		}
	}

	public Item findItem(int itemNum) {
		for (Item it : itemList) {
			if (it.num == itemNum)
				return it;
		}
		return null;
	}

	public void searchItem() {
		String kwd;
		int flag = 0;
		System.out.print("상품검색 키워드:");
		kwd = scan.next();
		for (Item it : itemList) {
			if (it.matches(kwd)) {
				it.print();
				flag = 1;
			}
		}
		if (flag == 0)
			System.out.print("없는 번호 또는 코드입니다.");
	}

	public void searchUser() {
		String kwd;
		System.out.print("사용자 검색 키워드:");
		kwd = scan.next();
		for (User user : userList) {
			if (user.matches(kwd)) {
				user.print();
				return;
			}
		}
		System.out.print("없는 번호 또는 코드입니다.");
	}

	public void searchUserWithItem() {
		String kwd;
		int num;
		System.out.print("구매한 사용자 검색할 상품번호 또는 코드: ");
		kwd = scan.next();
		for (Item it : itemList) {
			if (it.matches(kwd)) {
				num = it.num;
				it.print();
				for (User user : userList) {
					if (user.haveItem(num)) {
						user.print();
					}
				}
			}
		}

	}

	public void itemSold() {
		int num;
		System.out.print("상품별 판매수, 몇개 이상: ");
		num = scan.nextInt();
		for (Item it : itemList) {
			if (it.sold >= num) {
				System.out.printf("%s - %d개 팔림, %d 매출\n"
						, it.name, it.sold, it.sold * it.price);
			}
		}
	}
	
	public void countSoldItem() {
		for(User user : userList) {
			Item.countSold(user);
		}
	}

	public void itemSoldTogether() {
		String kwd;
		HashMap<Item, Integer> countMap = new HashMap<>();
		System.out.print("상품번호 또는 상품코드: ");
		kwd = scan.next();
		for(Item it : itemList) {
			if(it.matches(kwd)) {
				System.out.printf("[%d] %s와 함께 팔린 상품:\n",it.num,it.name);
				countMap = countSoldItem(it.num);
				System.out.print("3회:");
				for (Item item : countMap.keySet()) {
		            if(countMap.get(item)==3)System.out.printf(" %s",item.name);
		        }
				System.out.print("\n2회:");
				for (Item item : countMap.keySet()) {
		            if(countMap.get(item)==2)System.out.printf(" %s",item.name);
		        }
				System.out.print("\n1회:");
				for (Item item : countMap.keySet()) {
		            if(countMap.get(item)==1)System.out.printf(" %s",item.name);
		        }
			}
		}
	}
	
	public HashMap<Item, Integer> countSoldItem(int num) {
		ArrayList<Item> soldList = new ArrayList<>();
		HashMap<Item, Integer> countMap = new HashMap<>();
		for(User user : userList) {
			if(user.haveItem(num)) {
				for(Item it : user.basket) {
					if(it.num != num) soldList.add(it);
				}
			}
		}
		for (Item it : soldList) {
			countMap.put(it, countMap.getOrDefault(it, 0) + 1);
		}
		return countMap;
	}

	public static void main(String[] args) {
		Store my = new Store();
		my.run();

	}

}