package javahomework2;

import java.util.Scanner;

public class Department {

	Scanner scan = new Scanner(System.in);
	Student stList[];
	IntArray arr;
	int stuNum;
	int subject;

	void mymain() {
		System.out.print("학생 수:");
		stuNum = scan.nextInt();
		stList = new Student[stuNum];
		for (int i = 0; i < stuNum; i++) {
			stList[i] = new Student();
			stList[i].read(scan);
		}
		for (Student s : stList)
			s.print();
		while (true) {
			System.out.print("계속하시겠습니까?(y/n)");
			char answer = scan.next().charAt(0);
			if (answer == 'n') {
				System.out.println("안녕히 가세요");
				return;
			}
			if (answer == 'y') {
				arr = new IntArray(stuNum);
				System.out.print("점수 수정할 과목 번호 (1) 국어 (2) 영어 (3) 수학 ...");
				subject = scan.nextInt();
				System.out.printf("%d명 점수 입력...\n", stuNum);
				arr.generate(0, 100);
				arr.print();
				checkApply();
			}
		}
	}

	void checkApply() {
		System.out.print("점수 반영하시겠습니까? (y/n)");
		char answer = scan.next().charAt(0);
		if (answer == 'y') {
			applyNewScore();
		}
		if (answer == 'n') {
			generateNewScore();
		}
	}

	void applyNewScore() {
		System.out.print("(1) 점수 그대로 반영   (2) 높은 점수 반영 ");
		char n = scan.next().charAt(0);
		if (n == '1') {
			for (int i = 0; i < stuNum; i++) {
				stList[i].applyUpdatedScore(subject, arr.get(i));
			}
		}
		if (n == '2') {
			for (int i = 0; i < stuNum; i++) {
				stList[i].applyHigherScore(subject, arr.get(i));
			}
		}
		for (Student s : stList) {
			s.print();
		}
	}

	void generateNewScore() {
		System.out.print("메뉴 선택 (1) 점수 조정  (2) 다시 생성  (3) 취소/종료 ...");
		char n = scan.next().charAt(0);
		if (n == '1') {
			System.out.print("조정할 점수 구간 최저 최고 ");
			int lower = scan.nextInt();
			int upper = scan.nextInt();
			arr.adjust(lower, upper);
			arr.print();
		}
		if (n == '2') {
			System.out.printf("%d명 점수 입력...\n", stuNum);
			arr.generate(0, 100);
			arr.print();
		}
		if (n == '3') {
			System.out.println("점수 수정 취소");
			return;
		}
		checkApply();
	}

	public static void main(String[] args) {
		Department my = new Department();
		my.mymain();
	}
}
