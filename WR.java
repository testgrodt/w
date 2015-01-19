package iosys;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class WR {

	public static void main(String[] args) {
		write();
		read();
	}

	static void write() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("student.txt")));
			// out.writeInt(3);
			// out.write(2);
			// out.writeBoolean(true);
			// out.writeUTF("str");
			Student student = new Student("taras", 554082);
			out.writeObject(student);
			out.flush();
			out.close();
		} catch (FileAlreadyExistsException e) {
			System.out.println("FileAlreadyExistsException");

		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IOException");
		}
	}

	static void read() {

		try {
			// DataInputStream in = new DataInputStream(new BufferedInputStream(
			// new FileInputStream("file.txt")));
			ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("student.txt")));
			// System.out.println("in.readInt(): " + in.readInt());
			// System.out.println("in.read(): " + in.read());
			// System.out.println("in.readBoolean(): " + in.readBoolean());
			// System.out.println("in.readUTF(): " + in.readUTF());
			Student stud = (Student) in.readObject();
			System.out.println(stud.getName());
			System.out.println(stud.getId());
			in.close();
		}

		catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		}

		catch (IOException e) {
			System.out.println("IOException");
		}

	}

}

