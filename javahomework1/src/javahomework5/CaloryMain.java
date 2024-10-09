package javahomework5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CaloryMain {
	static ArrayList<Food> foods = new ArrayList<>();
	ArrayList<Eat> eatList = new ArrayList<>();
	Scanner scan = new Scanner(System.in);

	void mymain() {
		readFoods();
		printFoods();
		System.out.println();
		readEats();
		printEats();
	}

	void readEats() {
		Scanner inFile = openFile("eat2.txt");
		Eat e = null;
		while (inFile.hasNext()) {
			e = new Eat();
			e.read(inFile);
			eatList.add(e);
		}
	}

	void readFoods() {
		Scanner inFile = openFile("food2.txt");
		Food m = null;
		int n;
		while (inFile.hasNext()) {
			n = inFile.nextInt();
			m = switch(n) {
			case 1 -> new Food();
			case 2 -> new ExFood();
			default -> null;
			};
			m.read(inFile);
			foods.add(m);
		}
	}

	void printEats() {
		for (Eat e : eatList) {
			e.print();
		}
	}

	Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (IOException e) {
			System.out.println("File open failed : " + filename);
			throw new RuntimeException(e);
		}
		return filein;
	}

	void printFoods() {
		int i = 1;
		for (Food f : foods) {
			System.out.printf("[%2d] ", i++);
			f.print();
		}
	}

	static Food findFood(String name) {
		for (Food f : foods) {
			if (f.matches(name))
				return f;
		}
		return null;
	}

	public static void main(String[] args) {
		CaloryMain a = new CaloryMain();
		a.mymain();
	}
}
