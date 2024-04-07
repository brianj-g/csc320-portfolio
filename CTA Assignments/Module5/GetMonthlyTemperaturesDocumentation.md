
# Get Monthly Temperatures Program Documentation
# Portfolio Corrections

## CSC 320 - CTA Module 5 (Brian Gunther)

### Purpose
Develop a Java program that stores data in the form of monthly temperatures for a year. The program should prompt the user for the month to be viewed and display both the month and average temperature. If "year" is entered, the program outputs the temperature for each month along with the yearly average, and the highest and lowest monthly averages.

### Description
This program uses arrays to store the names of months and corresponding average monthly temperatures. It prompts the user to enter a month or the word "year" to view temperature data. Based on user input, it displays the average temperature for a specified month or a summary of temperatures throughout the year, including the yearly average, highest, and lowest monthly averages. The program utilizes looping and decision constructs in combination with arrays to accomplish its objectives.

### Portfolio Project Corrections
There were no required corrections to this program for the portfolio submission

### Program Code

```java
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
      Scanner s = new Scanner(System.in);
      String userInput;
      
      boolean validateInput = false;
      boolean enteredYear = false;
      
      int monthIndex, maxTempIndex, minTempIndex;
      monthIndex = maxTempIndex = minTempIndex = 0;
      
      double tempTotal = 0;
      
      final String[] monthArray = new String[] {
            "January", "February", "March", "April", 
            "May", "June", "July", "August", 
            "September", "October", "November", "December"
      };
      
      final double[] temperatureArray = new double[] {
            42.5,  40.5,  43.5,  48.6,  
            61.6,  61.6,  67.0,  68.0,  
            61.1,  54.2,  44.5,  44.2
      };
      
      // Prompt and input validation logic...
      
      if (!enteredYear) {
         System.out.println();
         printMonth(monthArray[monthIndex], temperatureArray[monthIndex], true);
      }
      else {
         // Loop through and print the temperatures for the whole year, including max, min, and average
      }
      
      System.out.println("\nData from U.S. National Weather Service (https://www.weather.gov)\n"
            + "Temperatures are based on averages from 2023 for Everett, WA.");
   }
}
```

### Expected Interaction and Output
- The program prompts the user to enter the name of a month or the word "year".
- For a specific month, it displays the month and its average temperature.
- If "year" is entered, it prints the temperature for each month, the yearly average temperature, and identifies the months with the highest and lowest average temperatures.
- The program also acknowledges the source of its temperature data, specifically from the U.S. National Weather Service, based on averages for 2023 in Everett, WA.
