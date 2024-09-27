package javahomework3;

import java.util.Scanner;

public class Student {
	String studentId;
	String name;
	int score;
	String phoneNum;
	int year;

	Student(String id) {
		studentId = id;
	}

	void read(Scanner scan) {
		name = scan.next();
		year = scan.nextInt();
		phoneNum = scan.next();
		score = scan.nextInt();
	}

	void print() {
		System.out.printf("%s %s (%d학년) %s - %d점\n", studentId, name, year, phoneNum, score);
	}

	boolean match(String kwd) {
		if (kwd.length() <= 3) {
			if (kwd.matches("\\d")) {
				if (year == Integer.parseInt(kwd))
					return true;
			}
			if (name.contains(kwd))
				return true;
			return false;
		} else {
			if (name.contains(kwd))
				return true;
			if (studentId.contains(kwd))
				return true;
			if (phoneNum.contains(kwd))
				return true;
			return false;
		}
	}

	boolean match(String[] kwdArr) {
		for (String str : kwdArr) {
			if (str.charAt(0) == '-') {
				if (match(str.substring(1)))
					return false;
			} else {
				if (!match(str))
					return false;
			}
		}
		return true;
	}

	boolean scoreCheck(int low, int high) {
		if (score >= low && score < high)
			return true;
		else
			return false;
	}
}
