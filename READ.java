package iosys;

import java.io.*;

public class READ {

	public static void main(String[] args) throws IOException {
		long start;
		long finish;
		long N = 1000000;
		start = System.nanoTime();
		BufferedInputStream_FileInputStream();
		finish = System.nanoTime();
		System.out.println("BufferedInputStream_FileInputStream: " + "\t"
				+ "\t" + "\t" + (finish - start) / N);

		start = System.nanoTime();
		DataInputStream_BufferedInputStream_FileInputStream();
		finish = System.nanoTime();
		System.out
				.println("DataInputStream_BufferedInputStream_FileInputStream: "
						+ "\t" + (finish - start) / N);

		start = System.nanoTime();
		DataInputStream_FileInputStream();
		finish = System.nanoTime();
		System.out.println("DataInputStream_FileInputStream: " + "\t" + "\t"
				+ "\t" + (finish - start) / N);

	}

	static String BufferedInputStream_FileInputStream() throws IOException {
		BufferedInputStream bufferedInputStream = new BufferedInputStream(
				new FileInputStream("C:\\1\\write.txt"));
		StringBuffer stringBuffer = new StringBuffer();
		while (bufferedInputStream.available() > 0)
			stringBuffer.append((char) bufferedInputStream.read());
		bufferedInputStream.close();
		return stringBuffer.toString();
	}

	static String DataInputStream_BufferedInputStream_FileInputStream()
			throws IOException {
		DataInputStream dataInputStream = new DataInputStream(
				new BufferedInputStream(new FileInputStream("C:\\1\\write.txt")));
		StringBuffer stringBuffer = new StringBuffer();
		while (dataInputStream.available() > 0)
			stringBuffer.append((char) dataInputStream.read());
		dataInputStream.close();
		return stringBuffer.toString();
	}

	static String DataInputStream_FileInputStream() throws IOException {
		DataInputStream dataInputStream = new DataInputStream(
				new FileInputStream("C:\\1\\write.txt"));
		StringBuffer stringBuffer = new StringBuffer();
		while (dataInputStream.available() > 0)
			stringBuffer.append((char) dataInputStream.read());
		dataInputStream.close();
		return stringBuffer.toString();
	}

}
