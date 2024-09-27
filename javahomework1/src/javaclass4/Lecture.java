package javaclass4;

import java.util.Scanner;

public class Lecture {
	String code;
	String lectureName;
	int year;
	String day;
	String time;
	
	Lecture(String code) {
		this.code = code;
	}
	
	public void read(Scanner scan) {
		lectureName = scan.next();
		year = scan.nextInt();
		day = scan.next();
		time = scan.next();
	}
	
	public void print() {
		System.out.printf("[%s] %s %d학년 (%s요일 %s)\n",code,lectureName,year,day,time);
	}
	
	public void match() {
		
	}
}
