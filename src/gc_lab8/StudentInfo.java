package gc_lab8;
import java.util.Random;
import java.util.Scanner;

public class StudentInfo {

	public static void main(String[] args) {
		Random rand = new Random(); // Random number generator to randomize values in the array
		String userWantsToContinue = "y"; // uses this string to determine if user wants to continue
		String userInput = ""; // use this string to accept user input
		int userInputInt = 0; // user input is translated to this int when appropriate
		Scanner scnr = new Scanner(System.in);
		String [][] studentInfo = new String [20][5]; // 20 students, 5 columns (number, name, age, hometown, food)  
		
		// populate the array with the for loop
		for(int i = 0; i < studentInfo.length ; i++) {
			studentInfo[i][0] = String.valueOf(i+1); //create the 1st column of the array, student number
			studentInfo[i][2] = generateAge(rand); // 3rd column, age randomized
			studentInfo[i][3] = generateTown(i); // 4th column, hometown one of 6 values assigned based on value of i
			studentInfo[i][4] = generateFood(rand); // 5th column, favourite food one of 6 values randomly assigned
		}
		
		// populate the array with names separately, demonstrating multiple ways to populate a loop
		studentInfo[0][1] = "Amanda";
		studentInfo[1][1] = "Bobbie";
		studentInfo[2][1] = "Chris";
		studentInfo[3][1] = "Darius";
		studentInfo[4][1] = "Elizabeth";
		studentInfo[5][1] = "Fitzroy";
		studentInfo[6][1] = "George";
		studentInfo[7][1] = "Harrison";
		studentInfo[8][1] = "Ingrid";
		studentInfo[9][1] = "Jessica";
		studentInfo[10][1] = "Krzysztof";
		studentInfo[11][1] = "Liam";
		studentInfo[12][1] = "Monica";
		studentInfo[13][1] = "Nanjit";
		studentInfo[14][1] = "Olivier";
		studentInfo[15][1] = "Patricia";
		studentInfo[16][1] = "Quincy";
		studentInfo[17][1] = "Robert";
		studentInfo[18][1] = "Samantha";
		studentInfo[19][1] = "Theo";
			
		do { // do loop to contain whether user wants to continue or not
			try { // try catch to make sure that the user inputs a valid number between 1 and 20
				System.out.print("Welcome to our Java class. Which student would you like to know more about? (enter a number 1-20): ");
				userInput = scnr.nextLine();
				userInputInt = Integer.parseInt(userInput) - 1;
				System.out.print("Student number " + studentInfo[userInputInt][0] + " is " + studentInfo[userInputInt][1] + ". ");
			} catch(Exception ex) {
				System.out.println("That student number does not exist. Please try again with an integer between 1-20.");
				System.out.println();
				continue; // go back up to top if an exception is caught
			}
			
			try {
				System.out.print("What information would you like to know about " + studentInfo[userInputInt][1] + "? (enter \"age\", \"food\", or \"town\"): ");
				userInput = scnr.nextLine();
				if(userInput.equals("food")) {
					System.out.println(studentInfo[userInputInt][1] + " favourite food is " + studentInfo[userInputInt][4]);
				} else if (userInput.equals("age")) {
					System.out.println(studentInfo[userInputInt][1] + " is " + studentInfo[userInputInt][2] + " years old.");
				} else if (userInput.equals("town")) {
					System.out.println(studentInfo[userInputInt][1] + " is from " + studentInfo[userInputInt][3] + ". ");
				} else {
					System.out.println("That input is not valid, please try again.");
					continue;
				}
			} catch (Exception ex) {
				System.out.println("That input is not valid, please try again.");
				continue;
			}
			
			System.out.print("Do you want to continue? (y/n) ");
			userWantsToContinue = scnr.nextLine();
			System.out.println();
		} while(userWantsToContinue.startsWith("y")||userWantsToContinue.startsWith("Y"));
		
		scnr.close();
	}
	
	// Random number generator to return a string age between 20 and 59
	public static String generateAge(Random rand) {
		int ageInt = rand.nextInt(40) + 20;
		String age = String.valueOf(ageInt);		
		return age;
	}
	
	// switch - case statement to give the students a town based on the value of i
	// i%6 will give 0, 1, 2, 3, 4, or 5 so String town will be one of 6 values 
	public static String generateTown(int i) {
		String town;
		int n = i%6;
		switch(n) {
		case 0:
			town = "Detroit";
			break;
		case 1:
			town = "Ann Arbor";
			break;
		case 2:
			town = "Novi";
			break;
		case 3:
			town = "London";
			break;
		case 4:
			town = "Chicago";
			break;
		default:
			town = "Winnipeg";
		}
		return town;
	}
	
	// generate a random number between 0-4, then assign a food based on the random number generated
	public static String generateFood(Random rand) {
		String food;
		int foodInt = rand.nextInt(5);
		if(foodInt == 0) {
			food = "Tacos";
		} else if (foodInt == 1) {
			food = "Pizza";
		} else if (foodInt == 2) {
			food = "Hamburgers";
		} else if (foodInt == 3) {
			food = "Salad";		
		} else {
			food = "Pasta";
		}
		return food;
	}
}
