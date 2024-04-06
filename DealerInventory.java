
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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

   // User input method for adding automobile
   public Automobile addAutomobileUserInput(Scanner s) {
      System.out.println("Please provide details about the car in the following prompts...");
      System.out.print("VIN (e.g., 1234ABCD): ");
      String vin = s.next();
      System.out.print("Make (e.g., Toyota): ");
      String make = s.next();
      System.out.print("Model (e.g., Camry): ");
      String model = s.next();
      System.out.print("Color (e.g., Blue); ");
      String color = s.next();
      System.out.print("Year (e.g., 2024): ");
      int year = s.nextInt();
      System.out.print("Mileage (e.g., 10000): ");
      int mileage = s.nextInt();
      System.out.print("Price (e.g., 20000.00): ");
      BigDecimal price = s.nextBigDecimal();
      
      return addAutomobile(vin, make, model, color, year, mileage, price);
   }
   
   
   // Method to remove an automobile from inventory (based on VIN)
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

   // Method to find a particular vehicle and return the Automobile object
   public Automobile getAutomobile(String vin) {
      try {
         int vinIndex = checkInventory(vin);
         
         if (vinIndex >= 0) {
            return dealerInventory.get(vinIndex);
         }
         else {
            System.out.println("Automobile could not be found in inventory");
         }
      }
      catch (Exception e) {
         System.out.println(e.getMessage());
         System.out.println("ERROR: Could not search automobile.");         
      }
      
      return null;
   }
   
   // Method to update a vehicle's *String* attributes
   public Automobile updateAttribute(String vin, String attribute, String value) {
      try {
         int vinIndex = checkInventory(vin);
         
         if (vinIndex >= 0) {
            switch(attribute.toLowerCase()) {
               case "make" : 
                  dealerInventory.get(vinIndex).setMake(value);
                  break;
               case "model" :
                  dealerInventory.get(vinIndex).setModel(value);
                  break;
               case "color" :
                  dealerInventory.get(vinIndex).setColor(value);
                  break;
               default :
                  System.out.println("Invalid attribute combination: " + attribute);
               
            }
            return dealerInventory.get(vinIndex);
         }
      }
      catch (Exception e) {
         System.out.println(e.getMessage());
         System.out.println("ERROR: Could not update automobile.");          
      }
      
      return null;
   }
   
   // Method (overload) to update a vehicle's numerical attributes
   public Automobile updateAttribute(String vin, String attribute, int value) {
      try {
         int vinIndex = checkInventory(vin);
         
         if(vinIndex >= 0) {
            Automobile currentAutomobile = dealerInventory.get(vinIndex);
            switch(attribute.toLowerCase()) {
               case "year" : 
                  currentAutomobile.setYear(value);
                  break;
               case "mileage" : 
                  currentAutomobile.setMileage(value);
                  break;
               default : 
                  System.out.println("Invalid attribute combination: " + attribute);
            }
            // Return the automobile object no matter what the case (including default case)
            return currentAutomobile;
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
         System.out.println("ERROR: Could not update automobile.");            
      }
      
      return null;
   }
   
   // Method (overload) to update the vehicle's price
   public Automobile updateAttribute(String vin, String attribute, BigDecimal value) {
      try {
         int vinIndex = checkInventory(vin);
         
         if(vinIndex >= 0) {
            Automobile currentAutomobile = dealerInventory.get(vinIndex);
            switch(attribute.toLowerCase()) {
               case "price" : 
                  currentAutomobile.setPrice(value);
                  break;
               default : 
                  System.out.println("Invalid attribute combination: " + attribute);
            }
            // Return the automobile object no matter what the case (including default case)
            return currentAutomobile;
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
         System.out.println("ERROR: Could not update automobile.");            
      }
      
      return null;
   }
   
   // User input method for updating attributes
   public Automobile updateAttributeUserInput(int selection) {
      
   }
   
   // Method to print an object to screen
   public void printAutomobile(String vin) {
      String[] retrievedAuto;
      
      try {
         int vinIndex = checkInventory(vin);
         
         if(vinIndex >= 0) {
            retrievedAuto = dealerInventory.get(vinIndex).listAutomobile();
            for (int i = 0; i < retrievedAuto.length; i++) {
               System.out.println(retrievedAuto[i]);
            } 
         }
         else {
            System.out.println("Could not find VIN: " + vin);
         }
      }
      catch (Exception e) {
         System.out.println(e.getMessage());
         System.out.println("ERROR: Could not retrieve automobile.");  
      }
   }
   
   // Method to print full inventory to a file
   public void printAll(String fileName) throws IOException {
      String[] retrievedAuto;
      FileOutputStream fileStream = null;
      PrintWriter filePrinter = null;
      try {
         fileStream = new FileOutputStream(fileName);
      } 
      catch (FileNotFoundException e) {
         System.out.println(e.getMessage());
      }
      try {
         filePrinter = new PrintWriter(fileStream);
         for (int inventoryIndex = 0; inventoryIndex < dealerInventory.size(); inventoryIndex++ ) {
            try {
               retrievedAuto = dealerInventory.get(inventoryIndex).listAutomobile();
               for (int i = 0; i < retrievedAuto.length; i++) {
                  filePrinter.println(retrievedAuto[i]);
               }
               filePrinter.println();
            }
            catch (Exception e) {
               System.out.println(e.getMessage());
               System.out.println("ERROR: Could not retrieve automobile.");  
            }
         }
      }
      catch (Exception e) {
         System.out.println(e.getMessage());
         System.out.println("There was a problem printing to file.");
      }
      filePrinter.close();
      fileStream.close();
   }
   
   public static void main(String[] args) throws IOException {
      // FIXME: The following are unit tests and should be removed
      // Begin Test data
//      System.out.println("Testing parameterized constructor.");
//      
//      String vin = "1234ABCD565432123";
//      String make = "Subaru";
//      String model = "Outback";
//      String color = "White";
//      int year = 2015;
//      int mileage = 13500;
//      BigDecimal price = new BigDecimal(13500);      
//      
//      String vin2 = "12234BCD56ASDF23";
//      String make2 = "Toyota";
//      String model2 = "Camry";
//      String color2 = "Blue";
//      int year2 = 2009;
//      int mileage2 = 120000;
//      BigDecimal price2 = new BigDecimal(6500);
//      
//      DealerInventory testInventory = new DealerInventory();
////      String[] testShow;
////      
////      System.out.println("Adding.");
//      testInventory.addAutomobile(vin, make, model, color, year, mileage, price);
//      testInventory.addAutomobile(vin2, make2, model2, color2, year2, mileage2, price2);
////      System.out.println("Retrieving.");
////      testShow = testInventory.getAutomobile(vin).listAutomobile();
////      for (int i = 0; i < testShow.length; i++) {
////         System.out.println(testShow[i]);
////      }
////      testShow = testInventory.getAutomobile(vin2).listAutomobile();
////      for (int i = 0; i < testShow.length; i++) {
////         System.out.println(testShow[i]);
////     }
////      //System.out.println("Removing.");
////      //testInventory.removeAutomobile(vin);
////      System.out.println("Retrieving (null)");
////      testInventory.getAutomobile(vin);
////      testShow = testInventory.getAutomobile(vin2).listAutomobile();
////      for (int i = 0; i < testShow.length; i++) {
////         System.out.println(testShow[i]);
////      }
////      
////      // Test print to file
////      System.out.println(System.getProperty("user.dir"));
////      testInventory.printAll("test.txt");
//      // Test print single to screen
//      testInventory.printAutomobile(vin2);
//      testInventory.updateAttribute(vin2, "color", "Red");
//      testInventory.updateAttribute(vin2, "make", "Honda");
//      testInventory.updateAttribute(vin2,  "model",  "Accord");
//      testInventory.updateAttribute(vin2, "year", 2001);
//      testInventory.updateAttribute(vin2, "mileage", 100000);
//      testInventory.updateAttribute(vin2, "price", new BigDecimal(7000));
//      
//      testInventory.printAutomobile(vin2);
//      //testInventory.removeAutomobile(vin2);
//      testInventory.addAutomobile("12343", make2, model2, color2, year2, mileage2, price2);
//      testInventory.printAutomobile(vin2);
//      testInventory.printAll("test4.txt");
      
        
//      
//      // End FIXME test data
//    
      // Instantiate a DealerInventory object
      DealerInventory myInventory = new DealerInventory();
      
      // Simple menu
      int menuSelector;
      Scanner s = new Scanner(System.in);
      Automobile returnedAuto;
      boolean returnedFlag;
      
      do {
         System.out.println("Dealership Inventory");
         System.out.println("[1] Add Vehicle");
         System.out.println("[2] Remove Vehicle");
         System.out.println("[3] Update Vehicle Details");
         System.out.println("[4] Show Vehicle Details");
         System.out.println("[5] Export Vehicle List");
         System.out.println("[6] Exit");
         
         System.out.println("\nEnter the number of your selection: ");
         menuSelector = s.nextInt();
         
         switch(menuSelector) {
            case 1 :
               returnedAuto = myInventory.addAutomobileUserInput(s);
               System.out.println("You added a new vehicle:");
               returnedAuto.listAutomobile();
               break;
            case 2 :
               System.out.print("Enter the VIN to remove: ");
               returnedFlag = myInventory.removeAutomobile(s.next());
               break;
            case 3 :
               System.out.println("Enter the VIN to update: ");
               String currentVin = s.next();
               System.out.println("Enter the number for the attribute to update:");
               System.out.println("[1] Make");
               System.out.println("[2] Model");
               System.out.println("[3] Color");
               System.out.println("[4] Year");
               System.out.println("[5] Mileage");
               System.out.println("[6] Price");
               
               
         }
         
         
      }
      while (menuSelector != 6);

   }

}
