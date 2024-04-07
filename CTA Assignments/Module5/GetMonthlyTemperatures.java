/* Module 5 CTA | Option 2: Get Monthly Temperatures
 * Develop a Java program that will store data in the form of monthly temperatures for a year. 
 * Store the month and temperature in two different arrays. 
 * Your program should prompt the user for the month to be viewed and display both the month and average temperature. 
 * If "year" is entered, the output for your program should provide the temperature for each month along with the 
 * yearly average as well as the highest and lowest monthly averages. Use the looping and decision constructs 
 * in combination with the arrays to complete this assignment.
 */
import java.util.Scanner;

public class GetMonthlyTemperatures {
   
   /* Simple method to print the month and temperature.
    * This is a private method because it should not be called outside of local usage.
    * The "verbose" parameter is included to optionally print a multiline formatted output.
    */
   private static void printMonth(String month, double temperature, boolean verbose) {
      if(verbose) {
         System.out.println("Month: " + month);
         System.out.printf("Average Temperature: %.1f\n", temperature);
      }
      else {
         System.out.printf("%s: %.1f\n", month, temperature);
      }

   }
   
   public static void main(String[] args) {
      // "s" object will be used to scan for user input and saved into the userInput string variable
      Scanner s = new Scanner(System.in);
      String userInput;
      
      // Initialize input validation to false to avoid unnecessary assignment in the do-while loop
      boolean validateInput = false;
      boolean enteredYear = false;
      
      // Declare integers to keep track of array index locations for month, max, and min temperatures
      int monthIndex, maxTempIndex, minTempIndex;
      monthIndex = maxTempIndex = minTempIndex = 0;
      
      // Declare and initialize the running total for yearly average calculation
      double tempTotal = 0;
      
      
      /* Initialize arrays for month names and temperature values.
      * These are created as final so that the structure cannot be 
      * re-initialized (though it should be noted that the values may be changed).
      */
      
      // Month array holds the names of the months as strings
      final String[] monthArray = new String[] {
            "January", "February", "March", "April", 
            "May", "June", "July", "August", 
            "September", "October", "November", "December"
      };
      
      /* Temperature array holds the average temperature for all twelve months,
       * referenced by an index number that matches the index for the month in monthArray.
       * Temperatures are taken from the 2023 monthly average temperatures for Everett, WA 
       * (https://www.weather.gov)
       */
      final double[] temperatureArray = new double[] {
            42.5,  40.5,  43.5,  48.6,  
            61.6,  61.6,  67.0,  68.0,  
            61.1,  54.2,  44.5,  44.2
      };
      
      /* Prompt the user for initial input of month.  
       * Perform input validation to ensure a correct month is chosen.
       * Use a do/while loop to re-prompt if incorrect input is received.
       */
      do {
         System.out.print("Enter the name of a month (e.g., January), or type the word "
               + "\"year\" to print all months: ");
         userInput = s.nextLine();
         
         // A for loop is used to cycle through the monthArray elements to ensure the input matches a value.
         for (int i = 0; i < monthArray.length; i++) {
            /* validateInput remains FALSE if the input does not match any element and 
             * does not match the word "year"
             * Convert all to lowercase to account for case mismatches.
             */
            if (userInput.toLowerCase().compareTo(monthArray[i].toLowerCase()) == 0) {
               validateInput = true;
               enteredYear = false;
               
               // Set the monthIndex for later use
               monthIndex = i;
               
               // Break out if a valid month is entered
               break;
            }
            
            // Check for "year" in the user input if month has not matched
            if (userInput.toLowerCase().compareTo("year") == 0){
               validateInput = true;
               enteredYear = true;
               
               // Break out if "year" is entered
               break;
            }
         }
         
         // Feedback to user if they don't type something valid
         if (!validateInput) {
            System.out.println("Invalid input. Please try again!");
         }
         
      // Go back to the DO statement until userInput contains a valid response
      } while (!validateInput);
      
      // Print the month and average temperature for that month if "year" wasn't entered (verbose flag set)
      if (!enteredYear) {
         System.out.println();
         printMonth(monthArray[monthIndex], temperatureArray[monthIndex], true);
      }
      else {
         System.out.println("\nMonthly Averages");
         System.out.println("__________");
         // Loop through and print the temperatures for the whole year
         for (int i = 0; i < monthArray.length; i++) {
            // Running total
            tempTotal += temperatureArray[i];
            
            // Initialize maxTemp and minTemp to the first element in the array
            if (i == 0) {
               maxTempIndex = i;
               minTempIndex = i;
            }
            else {
               // Set the max and min temperatures if comparisons succeed
               if (temperatureArray[maxTempIndex] < temperatureArray[i]) {
                  maxTempIndex = i;
               }
               if (temperatureArray[minTempIndex] > temperatureArray[i]) {
                  minTempIndex = i;
               }
            }
            
            // Print out the month and temperature (non-verbose)
            printMonth(monthArray[i], temperatureArray[i], false);

         }
         System.out.println("__________");
         
         // Compute the average using the running total (tempTotal) and the size of the array (12)
         System.out.printf("Yearly Average: %.1f\n", tempTotal / temperatureArray.length);
         
         // Print out the max and min temperatures and monthj
         System.out.printf("Monthly Maximum: %.1f (%s)\n", temperatureArray[maxTempIndex], monthArray[maxTempIndex]);
         System.out.printf("Monthly Minimum: %.1f (%s)\n", temperatureArray[minTempIndex], monthArray[minTempIndex]);
      }
      System.out.println("\nData from U.S. National Weather Service (https://www.weather.gov)\n"
            + "Temperatures are based on averages from 2023 for Everett, WA.");
   }
}
