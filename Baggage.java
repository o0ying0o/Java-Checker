/*
 * Student Name: Xueying Zou
 * Lab Professor: Amal Ibrahim
 * Due Date: Jul 28, 2024
 * Description: Assignment 2: baggage checking software
 * 				This class have constructors, setters and getters. Also toString()
 * 				returns summaries.
 */				
public class Baggage {
	//declarations
	private int length;	//in cm
	private int width;	//in cm
	private int height;	//in cm
	private double weight;	//in kg
	
	private static int count = 0;	//counting accepted baggage
	private static double totalWeight = 0;	//calculate the total weight of accepted baggage
	
	private static final int DEFAULT_LENGTH = 65;
	private static final int DEFAULT_WIDTH = 25;
	private static final int DEFAULT_HEIGHT = 50;
	private static final double DEFAULT_WEIGHT = 10.0;
	

	
	//constructors
	public Baggage() {

		super();
		this.length = DEFAULT_LENGTH;
		this.width = DEFAULT_WIDTH;
		this.height = DEFAULT_HEIGHT;
		this.weight = DEFAULT_WEIGHT;
	}
	
	public Baggage(int length, int width, int height, double weight) {
		super();
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
	}
	
	//getters and setters
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Baggage.count = count;
	}

	public static double getTotalWeight() {
		return totalWeight;
	}

	public static void setTotalWeight(double totalWeight) {
		Baggage.totalWeight = totalWeight;
	}

	//toString()
	public String toString() {
		String report;
		if(BaggageChecker.sumDimensionsExceedsMax(this) == true) {
			report = "This is oversized; it is not acceptable.";
		}else {
			//calculate total number and total weight
			count++;
			totalWeight += weight;
			
			report = "This bag has length " + length + " cm, width " + width + " cm, height " + height + " cm, and weight " + weight + " kg."; 
			
			//Check if it is a carry on baggage
			if(BaggageChecker.canBeUsedAsACarryOn(this) == true) {
				report += "\nThis bag can be used as a carry on.";
			}
			//Check if it is a overweight baggage and calculate surcharge
			if(BaggageChecker.allowedWeightIsMoreThanMax(this) == true) {
				
				String formatString = "\nThis bag is overweight; it exceeds the allowed weight of %.1f kg.A surcharge of $%.2f applies.";
				report += String.format(formatString, BaggageChecker.getMaxRegularWeight(), BaggageChecker.calculateWeightSurcharge(this));
				//report += "This bag is overweight; it exceeds the allowed weight of " + BaggageChecker.getMaxRegularWeight() + " kg.A surcharge of $" + BaggageChecker.calculateWeightSurcharge(this) + "  applies.\n";
			}
		}
		return report;
	}
	
}
