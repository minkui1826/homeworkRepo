package class6mgr;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Manager {
	ArrayList<Manageable> mList = new ArrayList<>();

	public void readAll(String filePath, Factory fac) {
		Scanner filein = openFile(filePath);
		Manageable m = null;
		while (filein.hasNext()) {
			m = fac.create(filein);
			m.read(filein);
			mList.add(m);
		}
	}

	public void printAll() {
		for (Manageable m : mList)
			m.print();
	}

	public Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (Exception e) {
			System.out.printf("파일 오픈 실패: %s\n", filename);
			throw new RuntimeException(e);
		}
		return filein;
	}

	public void search(Scanner scan) {
		// TODO Auto-generated method stub
		String kwd;
		while (true) {
			System.out.print("검색 키워드: ");
			kwd = scan.next();
			if (kwd.equals("end"))
				break;
			for (Manageable b : mList) {
				if (b.matches(kwd))
					b.print();
			}
		}
	}
}
