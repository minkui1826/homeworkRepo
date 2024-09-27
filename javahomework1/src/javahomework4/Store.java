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
				countMap = countsoldItem(it.num);
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
	
	public HashMap<Item, Integer> countsoldItem(int num) {
		ArrayList<Item> soldList = new ArrayList<>();
		HashMap<Item, Integer> countMap = new HashMap<>();
		for(User user : userList) {
			if(user.haveItem(num)) {
				for(Item it : user.basket) {
					if(it.num != num) soldList.add(it);
				}
			}
		}
		for(Item it : soldList) {
			countMap.put(it, countMap.getOrDefault(it, 0) + 1);
		}
		return countMap;
	}

	public static void main(String[] args) {
		Store my = new Store();
		my.run();

	}

}

/*
 * F3286 델리투명자 1140 F3134 비비드스프링노트 1050 F3206 베이직파우치 1260 F3221 토끼학용가위 1340
 * F3135 아트인덱스노트 1330 F3184 메탈릭반짝이풀 1510 F3124 돌돌이자 1310 F3109 A4좌철노트 1110 F3245
 * 컬러PP노트 1610 F3141 뽀로로색종이 1410 F3267 스케쥴플래너 4600 F3181 미니색연필 1560 F3170
 * 캠퍼스메모리노트 1270 F3100 MINI메모패드 1440 F3104 탁상용위클리플래너 1350 F3286 누사인펜꽃이 4440
 * F3124 A4방안노트 1780 F3294 다용도파우치 2460 F3282 수성점보크래용8색 3280 F3256 듀얼연필깍이 4830
 * F3131 팬트레이 1360 F3132 조약돌지우개 920 F3232 노트밸트오렌지 2950 F3158 노트밸트블루 2980 F3151
 * 누사인테이프디스펜서 1940 F3258 자이언트봉제필통 4210 F3223 스톱워치 1470 F3220 컴팩트스톱워치모닝글로리 1410
 * F3222 컬러홀릭노트 1430 F3102 학용직자 980 F3114 IV노트모닝글로리 950 F3212 심플여권케이스 6470 F3195
 * 누사인오거나이저 11530 0 lee lll 0 1 2 5 7 0 kim kkk 0 5 7 9 11 18 25 0 park ppp 11
 * 12 15 16 17 21 28 0 cho ccc 5 6 8 9 10 15 17 20 0 kang kkkk 21 19 20 25 27 28
 * 31 0 min mmm 0 2 8 9 10 12 16 17 21 0 bae bbb 0 21 25 28 29 0 0
 */