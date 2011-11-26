package ua.study.rudenko.data;

import java.io.*;
import java.util.Scanner;

public class DataFromFile implements IDataStore {

	private String fileName;

	@Override
	public double[][] load() throws IOException {
		double[][] data = null;
		Scanner scanner = null;
		int indexI = 0, indexJ = 0;
		try {
			scanner = new Scanner(new FileInputStream(fileName));

			for (; scanner.hasNextLine(); scanner.nextLine()) {
				indexI++;
			}

			data = new double[indexI][2];
			scanner = new Scanner(new FileInputStream(fileName));
			indexI = 0;
		
			while (scanner.hasNext()) {

				if (indexJ >= 2) {
					indexJ = 0;
					indexI++;
				}
				data[indexI][indexJ] = scanner.nextDouble();

				indexJ++;

			}

		} finally {
			scanner.close();
		}

		return data;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
