package javahomework1;

import java.util.Scanner;

public class MyClass_1 {
	public int size;
	Scanner scanner = new Scanner(System.in);

	void mymain() {
		while (true) {
			System.out.print("크기를 입력하세요...");
			this.size = scanner.nextInt();
			if (size > 0) {
				this.task1(size);
				System.out.println();
				this.task2(size);
				System.out.println();
				System.out.println();
				this.task3(size);
				System.out.println();
				this.task4(size);
				System.out.println();
				this.task5(size);
			} else
				break;
		}
		System.out.println("안녕히 가세요");
	}

	void task1(int size) {
		for (int i = 0; i < size; i++) {
			this.drawLine(size);
			System.out.println();
		}
	}

	void task2(int size) {
		this.drawLine(size);
		System.out.println();
		for (int i = 0; i < size - 2; i++) {
			this.drawEmptyLine(size);
			System.out.println();
		}
		this.drawLine(size);
	}

	void task3(int size) {
		for (int i = 1; i <= size; i++) {
			this.drawSpace(size - i);
			this.drawLine(2 * i - 1);
			System.out.println();
		}
	}

	void task4(int size) {
		for (int i = 1; i < size; i++) {
			this.drawSpace(size - i);
			this.drawEmptyLine(2 * i - 1);
			System.out.println();
		}
		this.drawLine(2 * size - 1);
	}

	void task5(int size) {
		System.out.print("가로 세로 박스 수: ");
		int row = scanner.nextInt();
		int col = scanner.nextInt();

		for (int n = 0; n < col; n++) {
			for (int i = 0; i < row; i++) {
				this.drawLine(size);
				this.drawSpace(1);
			}
			System.out.println();
			for (int i = 0; i < size - 2; i++) {
				for (int j = 0; j < row; j++) {
					this.drawEmptyLine(size);
					this.drawSpace(1);
				}
				System.out.println();
			}
			for (int i = 0; i < row; i++) {
				this.drawLine(size);
				this.drawSpace(1);
			}
			System.out.println();
			System.out.println();
		}
	}

	void drawLine(int size) {
		for (int i = 0; i < size; i++)
			System.out.print("*");
	}

	void drawSpace(int size) {
		for (int i = 0; i < size; i++)
			System.out.print(" ");
	}

	void drawEmptyLine(int size) {
		if (size > 1) {
			System.out.print("*");
			for (int i = 0; i < size - 2; i++)
				System.out.print(" ");
			System.out.print("*");
		} else
			System.out.print("*");
	}

	public static void main(String[] args) {
		MyClass_1 my = new MyClass_1();
		my.mymain();
	}
}