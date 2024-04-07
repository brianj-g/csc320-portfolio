import java.util.Scanner;

public class GroceryBillCalculator {
   public static void main(String[] args) {
      // Initialize input scanner
      Scanner s = new Scanner(System.in);
      
      // Initialize floating point variables
      double couponAmount;
      double userBillInput;
      // monthlyTotal set to 0.0 to accomodate addition operations
      double monthlyTotal = 0.0, monthlyTotalWithCoupon; 
      double weeklyAverage, weeklyAverageWithCoupon;
      
      // Prompt for coupon amount; Store in couponAmount
      System.out.print("Enter the coupon percentage discount in decimal format: ");
      couponAmount = s.nextDouble();
      
      // Prompt for grocery bills for weeks 1-4 and cumulatively add them
      System.out.print("Enter the bill for week 1: ");
      userBillInput = s.nextDouble();
      monthlyTotal = monthlyTotal + userBillInput;
      
      System.out.print("Enter the bill for week 2: ");
      userBillInput = s.nextDouble();
      monthlyTotal = monthlyTotal + userBillInput;
      
      System.out.print("Enter the bill for week 3: ");
      userBillInput = s.nextDouble();
      monthlyTotal = monthlyTotal + userBillInput;
      
      System.out.print("Enter the bill for week 4: ");
      userBillInput = s.nextDouble();
      monthlyTotal = monthlyTotal + userBillInput;
      
      // If coupon amount is less than or equal to zero or exceeds 100%, set it to 10%
      if ((couponAmount <= 0) || (couponAmount > 1.0)) {
         System.out.println("The coupon amount was out of range. Setting to 0.10 (10%).");
         couponAmount = 0.10;
      }
      else {
         System.out.printf("The coupon amount is %.2f.\n", couponAmount);
      }
      
      // Calculate and print the monthly total and weekly averages without coupon
      weeklyAverage = monthlyTotal / 4.0;
      
      System.out.printf("Monthly total (no coupon): $%.2f\n", monthlyTotal);
      System.out.printf("Weekly average (no coupon): $%.2f\n", weeklyAverage);
      
      // Calculate and print the monthly total and weekly averages with coupon discount
      monthlyTotalWithCoupon = monthlyTotal * (1.0 - couponAmount);
      weeklyAverageWithCoupon = monthlyTotalWithCoupon / 4.0;
      
      System.out.printf("Monthly total with coupon: $%.2f\n", monthlyTotalWithCoupon);
      System.out.printf("Weekly average with coupon: $%.2f\n", weeklyAverageWithCoupon);

      s.close();
   }
}
