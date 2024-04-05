
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
    * Method to add a new automobile to the inventory
    * @param vin
    * @param make
    * @param model
    * @param color
    * @param year
    * @param mileage
    * @param price
    * @return
    */
   public Automobile addAutomobile(String vin, String make, String model, String color, int year, int mileage, BigDecimal price) {
      
   }

   public static void main(String[] args) {

   }

}
