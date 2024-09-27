package javahomework3;

import java.util.ArrayList;
import java.util.Scanner;

public class Department {
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> stList = new ArrayList<>();

	void mymain() {
		int num;

		readAll();
		printAll();
		while (true) {
			System.out.print("(1) 전체출력 (2) 이름검색 (3) 통합검색 (4) 점수검색 (5) 멀티키워드 검색 (6) 종료");
			num = scan.nextInt();
			switch (num) {
			case 1: {
				printAll();
				break;
			}
			case 2: {
				searchName();
				break;
			}
			case 3: {
				searchTotal();
				break;
			}
			case 4: {
				searchScore();
				break;
			}
			case 5: {
				multiSearch();
				break;
			}
			case 6: {
				return;
			}
			}
		}
	}

	void readAll() {
		String id;
		while (true) {
			id = scan.next();
			Student st;
			if (id.equals("0"))
				break;
			st = new Student(id);
			st.read(scan);
			stList.add(st);
		}
	}

	void printAll() {
		for (Student st : stList) {
			st.print();
		}
	}

	void searchName() {
		String name;
		System.out.print("이름: ");
		name = scan.next();
		for (Student st : stList) {
			if (st.name.equals(name)) {
				st.print();
				return;
			}
		}
		System.out.println("없는 이름입니다.");
	}

	void searchTotal() {
		String kwd;
		System.out.print("통합검색 키워드:");
		kwd = scan.next();
		for (Student st : stList) {
			if (st.match(kwd))
				st.print();
		}
	}

	void searchScore() {
		String low, high;
		System.out.print("점수 검색 범위:");
		low = scan.next();
		high = scan.next();
		if (low.equals("-"))
			low = "0";
		if (high.equals("-"))
			high = "101";
		for (Student st : stList) {
			if (st.scoreCheck(Integer.parseInt(low), Integer.parseInt(high)))
				st.print();
		}
	}

	void multiSearch() {
		String line;
		String kwdArr[];
		scan.nextLine();
		System.out.print("검색키워드 여러개(빈칸으로 구분): ");
		line = scan.nextLine();
		kwdArr = line.split(" ");
		for (Student st : stList) {
			if (st.match(kwdArr))
				st.print();
		}
	}

	public static void main(String[] args) {
		Department my = new Department();
		my.mymain();

	}

}
