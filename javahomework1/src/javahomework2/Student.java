package javahomework2;

import java.util.Scanner;

public class Student {
	String name;
	String id;
	int year;
	int score[] = new int[3];
	static int Steps[] = { 90, 80, 70, 60, 0 };
	static char Grade[] = { 'A', 'B', 'C', 'D', 'F' };

	void read(Scanner scan) {
		id = scan.next();
		name = scan.next();
		year = scan.nextInt();
		for (int i = 0; i < 3; i++) {
			score[i] = scan.nextInt();
		}
	}

	void print() {
		System.out.printf("%s %s (%d학년)\t%d (%c) %d (%c) %d (%c)\n", this.id, this.name, this.year, this.score[0],
				this.getGrade(score[0]), this.score[1], this.getGrade(score[1]), this.score[2],
				this.getGrade(score[2]));
	}

	char getGrade(int score) {
		for (int i = 0; i < 5; i++) {
			if (score >= Steps[i]) {
				return Grade[i];
			}
		}
		return 'F';
	}

	void applyUpdatedScore(int subject, int newScore) {
		this.score[subject - 1] = newScore;
	}

	void applyHigherScore(int subject, int newScore) {
		this.score[subject - 1] = (this.score[subject - 1] > newScore) ? this.score[subject - 1] : newScore;
	}
}
