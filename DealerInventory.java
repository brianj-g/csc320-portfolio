
import java.util.ArrayList;
import java.math.BigDecimal;

public class DealerInventory {
   // Define a new ArrayList that will contain inventory objects of the Automobile class
   private ArrayList<Automobile> dealerInventory = new ArrayList<Automobile>();
   
   public int checkInventory(String vin) {
      for (int i = 0; i < dealerInventory.size(); i++) {
         if (vin.compareTo(dealerInventory.get(i).getVin()) == 0) {
            return i;
         }
      }
      return -1;
   }

   // Method to add an automobile object to inventory
   public Automobile addAutomobile(String vin, String make, String model, String color, int year, int mileage, BigDecimal price) {
      try {
         if (checkInventory(vin) < 0) {
            Automobile newAuto = new Automobile(vin, make, model, color, year, mileage, price);
            dealerInventory.add(newAuto);
            return newAuto;
         }
         else {
            System.out.println("Automobile with VIN " + vin + " is already in the inventory.");
         }
      } 
      catch (Exception e) {
         System.out.println(e.getMessage());
         System.out.println("ERROR: Could not add new automobile.");
      }

      return null;
   }
   
   // Method to remove an automobile from inventory (based on VIN()
   public boolean removeAutomobile(String vin) {
      try {
         int vinIndex = checkInventory(vin);
         
         if (vinIndex >= 0) {
            dealerInventory.remove(vinIndex);
            return true;
         }
         else {
            System.out.println("Automobile could not be found in inventory");
         }
      }
      catch (Exception e) {
         System.out.println(e.getMessage());
         System.out.println("ERROR: Could not remove automobile.");         
      }
      
      return false;
   }

   public static void main(String[] args) {

   }

}
