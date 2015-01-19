package iosys;

import java.io.*;

public class Write {

	public static void main(String[] args) throws IOException {
		long start;
		long finish;
		start = System.nanoTime();
		PrintWriter_BufferedWriter_FileWriter();
		finish = System.nanoTime();
		System.out.println("PrintWriter_BufferedWriter_FileWriter:\t"
				+ (finish - start) / 1000 + " microsec");

		start = System.nanoTime();
		PrintWriter_FileWriter();
		finish = System.nanoTime();
		System.out.println("PrintWriter_FileWriter:\t\t\t" + (finish - start)
				/ 1000 + " microsec");

		start = System.nanoTime();
		PrintWriter();
		finish = System.nanoTime();
		System.out.println("PrintWriter:\t\t\t\t" + (finish - start) / 1000
				+ " microsec");

	}

	static void PrintWriter() throws IOException {
		PrintWriter printWriter = new PrintWriter("C:\\1\\PrintWriter.txt");
		int i = 0;
		while (i++ < 10000)
			printWriter.write("i=" + i + "\n");
		printWriter.close();
	}

	static void PrintWriter_BufferedWriter_FileWriter() throws IOException {
		PrintWriter printWriter = new PrintWriter(new BufferedWriter(
				new FileWriter("C:\\1\\PrintWriter_BufferedWriter_FileWriter.txt")));
		int i = 0;
		while (i++ < 10000)
			printWriter.write("i=" + i + "\n");
		printWriter.close();
	}

	static void PrintWriter_FileWriter() throws IOException {
		PrintWriter printWriter = new PrintWriter(new FileWriter(
				"C:\\1\\PrintWriter_FileWriter.txt"));
		int i = 0;
		while (i++ < 10000)
			printWriter.write("i=" + i + "\n");
		printWriter.close();
	}

}
