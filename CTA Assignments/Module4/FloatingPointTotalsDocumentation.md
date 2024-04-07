
# Floating Point Totals Program Documentation
# Portfolio Corrections

## CSC320 - CTA Module 4 (Brian Gunther)

### Purpose
The program gathers five floating point values from the user using a while loop, ensuring the loop terminates successfully. It then calculates and prints the total, average, maximum, minimum, and interest on the total at 20%.

### Description
This Java program utilizes a while loop to prompt the user for five decimal values. It ensures that the input is valid through rudimentary input validation provided by the `nextDouble()` method of the Scanner class. The program calculates the total, average, maximum, and minimum of the entered values and computes a simple interest on the total amount at a rate of 20%.

### Portfolio Project Corrections
There were no required corrections to this program for the portfolio submission

### Program Code

```java
/* 
 * CSC320 - CTA Module 4 - March 10, 2024
 * Purpose: Use a while loop to gather five floating point values from a user, ensuring the loop terminates successfully. 
 * Then, print the total, average, maximum, minimum, and interest on the total at 20%.
 */

import java.util.Scanner;

public class FloatingPointTotals {

   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      double userInput;
      double runningTotal = 0;
      
      // Initialize min/max values so that these variables can be used in conditional statements
      double inputMin = 0, inputMax = 0;
      
      // Input counter is initialized at 0 to be used as the loop control variable
      int inputCounter = 0;
      
      // Max loop constant is the loop entry/exit check and serves as a quantity value for computing average
      final int MAX_LOOP = 5;
      
      while (inputCounter < MAX_LOOP) {
         System.out.print("Please enter a decimal value: ");
         userInput = s.nextDouble();
         runningTotal += userInput;
         
         if (inputCounter == 0) {
            inputMin = userInput;
            inputMax = userInput;
         }
         else {
            if (userInput < inputMin) {
               inputMin = userInput;
            }
            
            if (userInput > inputMax) {
               inputMax = userInput;
            }
         }
         
         inputCounter++;
           
      }
      
      System.out.printf("Total: %.2f\n", runningTotal);
      System.out.printf("Average: %.2f\n", runningTotal / MAX_LOOP);
      System.out.printf("Minimum: %.2f\n", inputMin);
      System.out.printf("Maximum: %.2f\n", inputMax);
      System.out.printf("Simple interest on total at 20%%: %.2f\n", runningTotal * 0.2);
   }

}
```

### Expected Interaction and Output
- The program prompts the user to enter five decimal values.
- It calculates and displays the total, average, maximum, and minimum of these values.
- Additionally, it calculates and displays the simple interest on the total amount at a rate of 20%.
