/*
 * Student Name: Xueying Zou
 * Lab Professor: Amal Ibrahim
 * Due Date: Jul 28, 2024
 * Description: Assignment 2: baggage checking software
 * 				This is the main() class. Instantiate a new Baggage object.
 * 				Output messages of valid baggage, program terminated and programmer's name
 */
public class BaggageLauncher {

	public static void main(String[] args) {
		
		//Set the original status true
		boolean hasNextBaggage = true;		
		
		//Declarations
		int length = 0;
		int width = 0;
		int height = 0;
		double weight = 0;		
		
		String promptLength = "Enter the length of the baggage (in cm): ";
		String promptWidth = "Enter the width (in cm): ";
		String promptHeight = "Enter the height (in cm): ";
		String promptWeight = "Enter the weight (in kg): ";
		String promptNext = "Do you wish to continue?  Enter 'No' to quit, anything else to continue: ";
		
		//Loop until entered "No"
		while (hasNextBaggage){			
	
			//Prompt messages and access static methods		
			length = InputData.validateInt(promptLength);
			width = InputData.validateInt(promptWidth);
			height = InputData.validateInt(promptHeight);
			weight = InputData.validateDouble(promptWeight);
			
			//Baggage baggage = new Baggage();	//Test default values 
			Baggage baggage = new Baggage(length, width, height, weight);
			
			//Output
			System.out.println(baggage.toString());
			//System.out.println(BaggageChecker.allowedWeightIsMoreThanMax(baggage));
			
			System.out.println();
			//If enter "No", end loop
			if (InputData.validateString(promptNext).equals("No")) {
				hasNextBaggage = false;
			}
		}
		//output summary
		System.out.println("The total number of valid bags entered was: " + Baggage.getCount());
		System.out.println("The total weight entered was: " + Baggage.getTotalWeight());
		System.out.println("The program has terminated.");
		System.out.println("Program by Xueying Zou");
	}

}
