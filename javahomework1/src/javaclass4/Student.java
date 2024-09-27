package javaclass4;

import java.util.Scanner;
import java.util.ArrayList;

public class Student {
	String id;
	String name;
	String phone;
	int year;
	ArrayList<Lecture> registeredList = new ArrayList<>();
	
	Student(String id) {
		this.id = id;
	}
	
	public void read(Scanner scan, Department department) {
		name = scan.next();
		phone = scan.next();
		year = scan.nextInt();
		String code;
		Lecture lecture = null;
		while(true) {
			code = scan.next();
			if(code.equals("0")) break;
			lecture = department.findLecture(code);
			registeredList.add(lecture);
		}
	}
	
	public void print() {
		System.out.format("%s %s %s (%d학년)",id,name,phone,year);
		System.out.println();
		for (Lecture mylec : registeredList) {
			System.out.print("\t");
			mylec.print();
		}
	}
	
	public void match() {
		
	}
	
}
