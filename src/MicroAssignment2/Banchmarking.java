package MicroAssignment2;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class Input {
	private Scanner r1;
	private LinkedList<Integer> store = new LinkedList<Integer>();
	private int min, max, med;
	
	/*
	 * Constructor to accepts the file name into the program.
	 * Print the error message if file not found.
	 * 
	 * @param input File object to scan.
	 */
	public Input(String input) {
		File f1 = new File(input);
		try {
			r1 = new Scanner(f1);
		}
		catch(FileNotFoundException e) {
			System.err.print("File not found, exit the program.");
			System.exit(0);
		}
	}
	
	public void read() {
		while(r1.hasNextInt()) {
			store.add(r1.nextInt());
		}
	}
	
	/*
	 * Override method of toString.
	 * It print the min, max, med, time_insert, time_min, time_max, and
	 * time_med with appropriate message.
	 * 
	 * @return String information of object.
	 */
	@Override
	public String toString() {
		return "";
	}
	
	public static void main(String[] args) {
		File f1 = new File("input1.txt");
		try {
			Scanner r2 = new Scanner(f1);
		}
		catch(FileNotFoundException e) {
			System.err.print("File not found, exit the program.");
			System.exit(0);
		}
	}
}
