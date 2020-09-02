package MicroAssignment1;

/**
 * RoomCarpet.java
 * The object RoomCarpet is parent class of RoomDimension class. 
 * Have method to show the total cost of room carpet.
 * 
 * @author Dongjoon Lee
 * @since 09/01/2020
 * @version 1.0
 * gitRepo url: https://github.com/roof558/CptS233.git
 * CptS 233: MicroAssignment #1
 */

public class RoomCarpet {
	private RoomDimension size;
	private double CarpetCost;
	
	/*
	 * Constructor class to set up the instance variables.
	 * 
	 * @param dim RoomDimension class that set the size of room carpet.
	 * @param cost Double variable that set to be carpet cost per feet.
	 */
	public RoomCarpet(RoomDimension dim, double cost) {
		this.size = dim;
		this.CarpetCost = cost;
	}
	
	/*
	 * Calculate the total cost of room carpet.
	 * The total is area * carpet cost.
	 * 
	 * @return Double variable that is total cost of carpet.
	 */
	public double getTotalCost() {
		return size.getArea() * CarpetCost;
	}
	
	/*
	 * Override toString class to print out the total room carpet price.
	 * 
	 * @return String variable to show carpet price.
	 */
	@Override
	public String toString() {
		return "The total room carpet price is " + this.getTotalCost();
	}
}
