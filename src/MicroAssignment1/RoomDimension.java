package MicroAssignment1;
/**
 * RoomDimension.java
 * Object RoomDimension that contains the instance variable of length and width that used
 * to calculate the total cost of room carpet.
 * Object provide the total area of room dimension.
 * 
 * @author Dongjoon Lee
 * @since 09/01/2020
 * @version 1.0
 */

public class RoomDimension {

	private double length;
	private double width;
	
	/*
	 * Constructor of class RoomDimension, set instance variable of class.
	 * 
	 * @param len Double varaibles that set to be instance variable length.
	 * @param w Double variable that set to be instance variable width.
	 */
	public RoomDimension(double len, double w) {
		this.length = len;
		this.width = w;
	}
	
	/*
	 * Method that calculate the area of room dimension.
	 * length * width
	 * 
	 * @return Double varaible that is area of room.
	 */
	public double getArea() {
		return length * width;
	}
	
	/*
	 * Override method of toString to print out class info.
	 * 
	 * @return String variable to print out the sentence.
	 */
	@Override
	public String toString() {
		return "The room dimension is " + getArea();
	}
}
