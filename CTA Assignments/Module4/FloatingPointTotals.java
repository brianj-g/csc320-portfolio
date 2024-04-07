/* 
 * CSC320 - CTA Module 4 - March 10, 2024
 * Purpose: Use a while loop to gather five floating point values from a user, ensuring the loop terminates successfully. 
 * Then, print the total, average, maximum, minimum, and interest on the total at 20%.
 */

//package cta;
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
         
         /* 
          * Using the nextDouble() method performs rudimentary input validation to ensure improper values are not accepted.
          * However, since there is no further exception handling, the program will terminate on a failed validation check.
          */
         userInput = s.nextDouble();
         runningTotal += userInput;
         

         /* 
          * On the first loop, the min/max variables must both be set to userInput to establish baseline.
          * In subsequent loops, conditional checks are used to determine min/max values.
          */
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
      
      // Outputs are formatted to two decimal places under the assumption that the numbers entered are dollar amounts.
      System.out.printf("Total: %.2f\n", runningTotal);
      System.out.printf("Average: %.2f\n", runningTotal / MAX_LOOP);
      System.out.printf("Minimum: %.2f\n", inputMin);
      System.out.printf("Maximum: %.2f\n", inputMax);
      System.out.printf("Simple interest on total at 20%%: %.2f\n", runningTotal * 0.2);
   }

}
