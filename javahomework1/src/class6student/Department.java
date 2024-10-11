package class6student;


import java.util.ArrayList;
import java.util.Scanner;

import class6mgr.Factory;
import class6mgr.Manageable;
import class6mgr.Manager;

public class Department extends Manager implements Factory {
	Scanner scan = new Scanner(System.in);
	static ArrayList<Lecture> lectureList = new ArrayList<>();

	void run() {
		readLectures();
		printLectures();
		readAll("student.txt",this);
		printAll();
		search(scan);
	}

	void readLectures() {
		Scanner filein = openFile("lecture.txt");
		Lecture lec = null;
		while (filein.hasNext()) {
			lec = new Lecture();
			lec.read(filein);
			lectureList.add(lec);
		}		
		filein.close();
	}

	private void printLectures() {
		// TODO Auto-generated method stub
		for (Lecture lec: lectureList) {
			lec.print();
		}
	}

	public static void main(String args[]) {
		Department my = new Department();
		my.run();
	}

	static public Lecture findLecture(String code) {
		// TODO Auto-generated method stub
		for (Lecture lec: lectureList) {
			if (lec.matches(code))
				return lec;
		}
		return null;
	}

	@Override
	public Manageable create(Scanner scan) {
		// TODO Auto-generated method stub
		return new Student();
	}
}