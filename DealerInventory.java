
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
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
      } catch (Exception e) {
         System.out.println(e.getMessage());
         System.out.println("ERROR: Could not add new automobile.");
      }

      return null;
   }

   // User input method for adding automobile
   public Automobile addAutomobileUserInput() {
      Scanner s = new Scanner(System.in);
      
      System.out.println("Please provide details about the car in the following prompts...");
      System.out.print("VIN (e.g., 1234ABCD): ");
      String vin = s.next();
      System.out.print("Make (e.g., Toyota): ");
      String make = s.next();
      System.out.print("Model (e.g., Camry): ");
      String model = s.next();
      System.out.print("Color (e.g., Blue): ");
      String color = s.next();
      System.out.print("Year (e.g., 2024): ");
      int year = -1;
      try {
         year = s.nextInt();
      } catch (Exception e) {
         if (e.getMessage() != null) {
            System.out.println(e.getMessage());   
         } else {
            System.out.println("ERROR: Invalid year");
         }

         return null;
      }
      System.out.print("Mileage (e.g., 10000): ");
      int mileage = -1;
      try {
         mileage = s.nextInt();
      } catch (Exception e) {
         if (e.getMessage() != null) {
            System.out.println(e.getMessage());   
         } else {
            System.out.println("ERROR: Invalid mileage"); 
         }

         return null;
      }
      System.out.print("Price (e.g., 20000.00): ");
      BigDecimal price = new BigDecimal(-1);
      try {
         price = s.nextBigDecimal();
      } catch (Exception e) {
         if (e.getMessage() != null) {
            System.out.println(e.getMessage());   
         } else {
            System.out.println("ERROR: Invalid price");
         }

         return null;
      }
      
      return addAutomobile(vin, make, model, color, year, mileage, price);
   }
   
   
   // Method to remove an automobile from inventory (based on VIN)
   public boolean removeAutomobile(String vin) {
      try {
         int vinIndex = checkInventory(vin);
         
         if (vinIndex >= 0) {
            dealerInventory.remove(vinIndex);
            return true;
         } else {
            System.out.println("Automobile could not be found in inventory");
         }
      }
      catch (Exception e) {
         if (e.getMessage() != null) {
            System.out.println(e.getMessage());   
         } else {
            System.out.println("ERROR: Could not remove automobile.");     
         }
    
      }
      
      return false;
   }

   // Method to find a particular vehicle and return the Automobile object
   public Automobile getAutomobile(String vin) {
      try {
         int vinIndex = checkInventory(vin);
         
         if (vinIndex >= 0) {
            return dealerInventory.get(vinIndex);
         } else {
            System.out.println("Automobile could not be found in inventory");
         }
      } catch (Exception e) {
         if (e.getMessage() != null) {
            System.out.println(e.getMessage());   
         } else {
            System.out.println("ERROR: Could not search automobile.");    
         }
     
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
      } catch (Exception e) {
         if (e.getMessage() != null) {
            System.out.println(e.getMessage());   
         } else {
            System.out.println("ERROR: Could not update automobile.");
         }
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
         if (e.getMessage() != null) {
            System.out.println(e.getMessage());   
         } else {
            System.out.println("ERROR: Could not update automobile.");
         }         
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
         if (e.getMessage() != null) {
            System.out.println(e.getMessage());   
         } else {
            System.out.println("ERROR: Could not update automobile.");
         }          
      }
      
      return null;
   }
   
   // User input method for updating attributes
   public Automobile updateAttributeUserInput(String vin) {
      Scanner s = new Scanner(System.in);
      int selection;
      
      
      try {
         int vinIndex = checkInventory(vin);
         
         if(vinIndex >= 0) {
            System.out.println("Enter the number for the attribute to update:");
            System.out.println("[1] Make");
            System.out.println("[2] Model");
            System.out.println("[3] Color");
            System.out.println("[4] Year");
            System.out.println("[5] Mileage");
            System.out.println("[6] Price");
            System.out.println("Enter the new value: ");
            
            selection = s.nextInt();
            switch (selection) {
               case 1 :
                  String newMake = s.next();
                  updateAttribute(vin, "make", newMake);
                  break;
               case 2 :
                  String newModel = s.next();
                  updateAttribute(vin, "model", newModel);
                  break;
               case 3 :
                  String newColor = s.next();
                  updateAttribute(vin, "color", newColor);
                  break;
               case 4 :
                  int newYear;
                  try {
                     newYear = s.nextInt();
                     updateAttribute(vin, "year", newYear);
                  } catch (Exception e){
                     if (e.getMessage() != null) {
                        System.out.println(e.getMessage());   
                     } else {
                        System.out.println("ERROR: Could not update year.");
                     }
                  }
                  break;
               case 5 :
                  int newMileage;
                  try {
                     newMileage = s.nextInt();
                     updateAttribute(vin, "mileage", newMileage);
                  } catch (Exception e){
                     if (e.getMessage() != null) {
                        System.out.println(e.getMessage());   
                     } else {
                        System.out.println("ERROR: Could not update mileage.");
                     }
                  }
                  break;
               case 6 :
                  BigDecimal newPrice;
                  try {
                     newPrice = s.nextBigDecimal();
                     updateAttribute(vin, "price", newPrice);
                  } catch (Exception e){
                     if (e.getMessage() != null) {
                        System.out.println(e.getMessage());   
                     } else {
                        System.out.println("ERROR: Could not update price.");
                     }
                  }
                  break;
            }
            Automobile currentAuto = dealerInventory.get(vinIndex);
            return currentAuto;
         } else {
            System.out.println("VIN could not be located: " + vin);
         }
      } catch (Exception e){
         if (e.getMessage() != null) {
            System.out.println(e.getMessage());   
         } else {
            System.out.println("ERROR: Could not update automobile.");
         }
      }
      
      return null;
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
            System.out.println("\nCould not find VIN: " + vin);
         }
      } catch (Exception e) {
         if (e.getMessage() != null) {
            System.out.println(e.getMessage());   
         } else {
            System.out.println("ERROR: Could not retrieve automobile.");
         }
      }
   }
   
   // Method to print full inventory to a file
   public void saveAll(String fileName) throws IOException {
      String[] retrievedAuto;
      FileOutputStream fileStream = null;
      PrintWriter filePrinter = null;
      File file = new File(fileName);
      try {
         fileStream = new FileOutputStream(file);
      } catch (FileNotFoundException e) {
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
               if (e.getMessage() != null) {
                  System.out.println(e.getMessage());   
               } else {
                  System.out.println("ERROR: Could not retrieve automobile.");
               }
            }
         }
      } catch (Exception e) {
         if (e.getMessage() != null) {
            System.out.println(e.getMessage());   
         } else {
            System.out.println("ERROR: There was a problem saving to file.");
         }
      }
      
      System.out.println("Saved to " + file.getAbsolutePath());
      
      filePrinter.close();
      fileStream.close();
   }
   
   public void savePrompt() {
      String fileName = "inventory.";
      Scanner s = new Scanner(System.in);
      
      System.out.print("Current working directory: ");
      System.out.println(System.getProperty("user.dir"));
      System.out.println();
      System.out.print("Enter the filename to save (inventory.txt is the default): ");
      if(s.next() != null) {
         fileName = s.next();
      }
      
      try {
         saveAll(fileName);
      } catch (IOException e) {
         if (e.getMessage() != null) {
            System.out.println(e.getMessage());   
         } else {
            System.out.println("ERROR: There was a problem saving to file.");
         }
      }
   }
   
   public static void main(String[] args) throws IOException {   
      // Instantiate a DealerInventory object
      DealerInventory myInventory = new DealerInventory();
      
      // Declare variables to be used in user menu
      Automobile returnedAuto;
      Automobile currentAuto;
      String currentVin;
      int menuSelector;
      Scanner s;
      
      
      // Simple menu loop
      do {
         returnedAuto = null;
         s = new Scanner(System.in);
         
         System.out.println();
         System.out.println("Dealership Inventory");
         System.out.println("[1] Add Vehicle");
         System.out.println("[2] Remove Vehicle");
         System.out.println("[3] Update Vehicle Details");
         System.out.println("[4] Show Single Vehicle");
         System.out.println("[5] Show All Vehicles");
         System.out.println("[6] Save Vehicle List to File");
         System.out.println("[7] Exit");
         System.out.println();
         System.out.print("Enter the number of your selection: ");
         menuSelector = s.nextInt();
         
         switch(menuSelector) {
            case 1 :
               returnedAuto = myInventory.addAutomobileUserInput();
               if (null != returnedAuto) {
                  System.out.println();
                  System.out.println("You added a new vehicle:");
                  myInventory.printAutomobile(returnedAuto.getVin());
               } else {
                  System.out.println("Vehicle was not added.");
               }
               break;
            case 2 :
               System.out.print("Enter the VIN to remove: ");
               myInventory.removeAutomobile(s.next());
               break;
            case 3 :
               System.out.print("Enter the VIN to update: ");
               currentVin = s.next();
               returnedAuto = myInventory.updateAttributeUserInput(currentVin);
               if (null != returnedAuto) {
                  System.out.println("Returned:");
                  myInventory.printAutomobile(returnedAuto.getVin());   
               }
               break;
            case 4 :
               System.out.print("Enter the VIN to display: ");
               currentVin  = s.next();
               myInventory.printAutomobile(currentVin);
               break;
            case 5 :
               System.out.println("Dealer Inventory Report");
               System.out.println();
               for (int i = 0; i < myInventory.dealerInventory.size(); i++) {
                  currentAuto = myInventory.dealerInventory.get(i);
                  myInventory.printAutomobile(currentAuto.getVin());
                  System.out.println();
               }
            case 6 :
               System.out.print("Current working directory: ");
               System.out.println(System.getProperty("user.dir"));
               System.out.println();
               System.out.print("Enter the filename to save (inventory.txt is the default): ");
               myInventory.savePrompt();
               break;
            case 7 :
               System.out.print("Would you like to save a copy of your inventory first? [Y/N]: ");
               String saveConfirm = s.next();
               switch (saveConfirm.toLowerCase()) {
                  case "y" : 
                     myInventory.savePrompt();
                  case "n" :
                     System.out.println("Exiting. Thank you for using the program!");
                  default :
                     System.out.println("Invalid option. Returning to menu.");
                     menuSelector = -1;
               }

         } 
         
      }
      while (menuSelector != 7);
      
      s.close();
   }

}
