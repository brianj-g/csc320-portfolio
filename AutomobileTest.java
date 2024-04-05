
import java.math.BigDecimal;
public class AutomobileTest {
   
   public void testAutomobile(Automobile testAuto) {

   }

   public static void main(String[] args) {
      
      // Test parameterized constructor
      System.out.println("Testing parameterized constructor.");
      
      String vin = "1234ABCD565432123";
      String make = "Subaru";
      String model = "Outback";
      String color = "Blue";
      int year = 2015;
      int mileage = 1000;
      BigDecimal price = new BigDecimal(12808);
      
      Automobile testAuto = new Automobile(vin, make, model, color, year, mileage, price);
      
      if (testAuto.getVin().compareTo(vin) != 0) {
         System.out.println("FAILED: getVin()");
      }
      
      if (testAuto.getMake().compareTo(make) != 0) {
         System.out.println("FAILED: getMake()");
      }

      if (testAuto.getModel().compareTo(model) != 0) {
         System.out.println("FAILED: getModel()");
      }

      if (testAuto.getColor().compareTo(color) != 0) {
         System.out.println("FAILED: getColor()");
      }

      if (testAuto.getYear() != year) {
         System.out.println("FAILED: getYear()");
      }

      if (testAuto.getMileage() != mileage) {
         System.out.println("FAILED: getMileage()");
      }
      
      if (testAuto.getPrice().compareTo(price) != 0) {
         System.out.println("FAILED: getPrice()");
      }
      
      for (int i = 0; i < testAuto.listAutomobile().length; i++) {
         System.out.println(testAuto.listAutomobile()[i]);
      }
      
      System.out.println("Done.");
      
      


   }

}
