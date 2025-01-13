/*
 * Student Name: Xueying Zou
 * Lab Professor: Amal Ibrahim
 * Due Date: Jul 28, 2024
 * Description: Assignment 2: baggage checking software
 * 				Have methods which take a Baggage object as parameter.
 */
public class BaggageChecker {
	//declarations
	private static final double MAX_REGULAR_WEIGHT = 22.0;
	private static final double SURCHARGE_PER_KG = 3.00;
	private static final double MAX_CARRYON_DIMENSION = 36;
	private static final double MAX_SUM_DIMENSIONS = 192;
	
	
	//get max regular weight
	public static double getMaxRegularWeight() {
		return MAX_REGULAR_WEIGHT;
	}

	//if the baggage object passed has a weight greater than the maximum permissible regular weight of 22.0 kg
	public static boolean allowedWeightIsMoreThanMax(Baggage baggage) {
		boolean result = false;
		if (baggage.getWeight() > MAX_REGULAR_WEIGHT) {
			result = true;
		}		
		return result;
	}
	
	//use the baggage's weight to return a SURCHARGE_PER_KG of $3.00 for each kg above the MAX_REGULAR_WEIGHT
	public static double calculateWeightSurcharge(Baggage baggage) {
		double result = 0;
		if (baggage.getWeight() > MAX_REGULAR_WEIGHT) {
			result = SURCHARGE_PER_KG * (baggage.getWeight() - MAX_REGULAR_WEIGHT);
		}		
		return result;		
	}
	
	//returns true if the length, width, and height are each less than 36 cm
	public static boolean canBeUsedAsACarryOn(Baggage baggage) {
		boolean result = false;
		if(baggage.getLength() < MAX_CARRYON_DIMENSION && baggage.getWidth() < MAX_CARRYON_DIMENSION && baggage.getHeight() < MAX_CARRYON_DIMENSION) {
			result = true;
		}
		return result;
	}
	
	//see if the sum of the baggage’s length, width, and height exceed 192 cm
	public static boolean sumDimensionsExceedsMax(Baggage baggage) {
		boolean result = false;
		if(baggage.getLength() + baggage.getWidth() + baggage.getHeight() > MAX_SUM_DIMENSIONS) {
			result = true;
		}
		return result;
	}
}
