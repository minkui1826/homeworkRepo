package javaclass4;

import java.util.Scanner;
import java.util.ArrayList;

public class Department {
	ArrayList<Student> studentList = new ArrayList<>();
	ArrayList<Lecture> lectureList = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	
	public void run() {
		readAllLectures();
		readAllStudents();
		printAllStudents();
	}
	
	public void readAllStudents() {
		String id;
		while(true) {
			id = scan.next();
			if(id.equals("0")) break;
			Student st = new Student(id);
			st.read(scan,this);
			studentList.add(st);
		}
	}
	
	public void printAllStudents() {
		for(Student st : studentList) {
			st.print();
		}
	}
	
	public void readAllLectures() {
		String code;
		while(true) {
			code = scan.next();
			if(code.equals("end")) break;
			Lecture lec = new Lecture(code);
			lec.read(scan);
			lectureList.add(lec);
		}
	}
	
	public Lecture findLecture(String code) {
		for(Lecture lec : lectureList) {
			if(lec.code.equals(code)) return lec;
		}
		return null;
	}
	
	public static void main(String[] args) {
		Department my = new Department();
		my.run();
	}

}
