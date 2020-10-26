package MicroAssignment2;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * CptS233: MicroAssignment #2
 * Banchmarking.java
 * This method is to find the min, med, max of the inserted LinkedList
 * that input from the text file.
 * It printing out the finding min, med, max time taking.
 * 
 * @author Justin Lee
 * @version v1.0
 * @since 09/18/20
 * {@link} gitRepo url: https://github.com/roof558/CptS233.git
 */

public class Banchmarking {
	private Scanner r1;
	private LinkedList<Integer> store = new LinkedList<Integer>();
	private int min, max, med;
	private String insertionTimeInfo;
	
	
	/*
	 * Constructor to accepts the file name into the program.
	 * Print the error message if file not found.
	 * Adding the values from the textfile into linkedlist.
	 * Also calculate the time of inserting.
	 * 
	 * @param input File object to scan.
	 */
	public Banchmarking(String input) {
		File f1 = new File(input);
		try {
			r1 = new Scanner(f1);
		}
		catch(FileNotFoundException e) {
			System.err.print("File not found, exit the program.");
			System.exit(0);
		}
		
		long insertTimeS = System.nanoTime();
		while(r1.hasNextInt()) {
			int value = r1.nextInt();
			add(value);
		}
		long insertTimeE = System.nanoTime();
		
		this.insertionTimeInfo = "Time inesrtion: " + 
		(insertTimeE - insertTimeS)/1000 + " Microseconds";
		
//		Collections.sort(store);  
	}
	
	/*
	 * Method to add into sorted linkedlist. 
	 * Using binary search to add into sort way.
	 * Bring the method and change from the other people's work that is
	 * about sorted arraylist insertion.
	 * https://gist.github.com/anizzomc/11390613
	 */
	public void add(int input) {
		int left, right, mid;
		left = 0;
		right = store.size();
		
		while(left < right) {
			mid = (left + right) / 2;
			int result = this.compareTo(store.get(mid), input);
			
			if(result > 0) right = mid;
			else left = mid + 1;
		}
		
		store.add(left, input);
	}
	
	/*
	 * Method to compare between 2 integer variables.
	 * 
	 * return -1, 0 or 1 by the results.
	 */
	public int compareTo(int input, int input2) {
		if(input > input2) return 1;
		else if(input < input2) return -1;
		return 0;
	}
	
	/*
	 * Method to find the median and the times takes to find.
	 * 
	 * @return String text of linkedlist median information
	 */
	public String findMed() {
		long medTimeS = System.nanoTime();
		if(store.size() % 2 == 0) {
			int med1 = store.get(store.size()/2);
			int med2 = store.get(1 + (store.size()/2));
			med = (med1 + med2) / 2;
		}
		else {
			med = store.get((store.size() / 2) + 1);
		}
		long medTimeE = System.nanoTime();
		return "Time median: " + med + " and it took " +
				(medTimeE - medTimeS)/1000 + " Microseconds";
	}
	
	/*
	 * Method to find the maximum and the times takes to find.
	 * 
	 * @return String text of linkedlist maximum information
	 */
	public String findMax() {
		long maxTimeS = System.nanoTime();
		this.max = store.get(store.size()-1);
		long maxTimeE = System.nanoTime();
		return "Time maximum: " + max + " and it took " + 
				(maxTimeE - maxTimeS)/1000 + " Microseconds";
	}
	
	/*
	 * Method to find the minimum and the times takes to find.
	 * 
	 * @return String text of linkedlist minimum information.
	 */
	public String findMin() {
		long minTimeS = System.nanoTime();
		this.min = store.get(0);
		long minTimeE = System.nanoTime();
		return "Time min: " + min + " and it took " + 
				(minTimeE - minTimeS)/1000 + " Microseconds";
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
		return this.insertionTimeInfo + "\n" + 
	this.findMax() + "\n" + this.findMed() + "\n" + this.findMin();
	}
	
	/*
	 * This method is testing method to check the linkedlist is sorted
	 * or not.
	 * 
	 * @return String value to printing the linkedlist.
	 */
	public String printList() {
		return store.toString();
	}
}
