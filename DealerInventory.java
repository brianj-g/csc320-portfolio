
import java.util.ArrayList;
import java.math.BigDecimal;

public class DealerInventory {
   // Define a new ArrayList that will contain inventory objects of the Automobile class
   private ArrayList<Automobile> dealerInventory = new ArrayList<Automobile>();
   
   public boolean checkInventory(String vin) {
      for (int i = 0; i < dealerInventory.size(); i++) {
         if (vin.compareTo(dealerInventory.get(i).getVin()) == 0) {
            return true;
         }
      }
      return false;
   }
   /**
    * Method to create a new automobile in the dealer inventory ArrayList
    */
   public Automobile addAutomobile(String vin, String make, String model, String color, int year, int mileage, BigDecimal price) {
      try {
         if (!checkInventory(vin)) {
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

   public static void main(String[] args) {

   }

}
