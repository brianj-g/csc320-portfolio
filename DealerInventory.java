
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
            System.out.println();
            System.out.println("Automobile with VIN " + vin + " is already in the inventory.");
         }
      } catch (Exception e) {
         if (e.getMessage() != null) {
            System.out.println(e.getMessage());   
         } else {
            System.out.println("Unable to add automobile.");
         }
      }

      return null;
   }

   // User input method for adding automobile
   public Automobile addAutomobileUserInput() {
      Scanner s = new Scanner(System.in);
      
      System.out.println("Please provide details about the car in the following prompts...");

      System.out.print("VIN (e.g., 1234ABCD): ");
      String vin = s.nextLine().trim();
      
      // VIN is mandatory and will loop until one is entered.
      while (vin.isEmpty()) {
          System.out.println("VIN cannot be blank.");
          System.out.print("VIN (e.g., 1234ABCD): ");
          vin = s.nextLine().trim();
      }
      
      // Make, Model, and Color can be optional. User can skip past by hitting "enter".
      System.out.print("Make (e.g., Toyota): ");
      String make = s.nextLine();
      while (make.isEmpty()) {
          System.out.println("Make cannot be blank.");
          System.out.print("Make (e.g., Toyota): ");
          make = s.nextLine();
      }

      System.out.print("Model (e.g., Camry): ");
      String model = s.nextLine();
      while (model.isEmpty()) {
         System.out.println("Model cannot be blank.");
         System.out.print("Model (e.g., Camry): ");
         model = s.nextLine();
      }

      System.out.print("Color (e.g., Blue): ");
      String color = s.nextLine();
      while (color.isEmpty()) {
         System.out.println("Color cannot be blank.");
         System.out.print("Color (e.g., Blue): ");
         color = s.nextLine();
      }
      
      int year = -1;
      boolean validYear = false;
      do {
         System.out.print("Year (e.g., 2024): ");
         String lineInput = s.nextLine();
         if ("".equals(lineInput)) {
            System.out.println("Invalid input. Please enter the year as an integer.");
         } else {
            try {
               year = Integer.parseInt(lineInput);
               validYear = true;
            } catch (Exception e) {
               System.out.println("Invalid input. Please enter the year as an integer.");
            }
         }
      } while (!validYear);      
      
      int mileage = -1;
      boolean validMileage = false;
      do {
         System.out.print("Mileage (e.g., 10000): ");
         String lineInput = s.nextLine();
         if ("".equals(lineInput)) {
            System.out.println("Invalid input. Please enter the mileage as an integer.");
         } else {
            try {
               mileage = Integer.parseInt(lineInput);
               validMileage = true;
            } catch (Exception e) {
               System.out.println("Invalid input. Please enter the mileage as an integer.");
            }
         }
      } while (!validMileage); 
      
      BigDecimal price = new BigDecimal(-1);
      boolean validPrice = false;
      do {
         System.out.print("Price (e.g., 20000.00): ");
         String lineInput = s.nextLine();
         if ("".equals(lineInput)) {
            System.out.println("Invalid input. Please enter a valid price.");
         } else {
            try {
               price = new BigDecimal(lineInput);
               validPrice = true;
            } catch (Exception e) {
               System.out.println("Invalid input. Please enter a valid price.");
            }
         }
      } while (!validPrice); 
      
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
            
            Automobile currentAuto = dealerInventory.get(vinIndex);
            System.out.println();
            System.out.println("***Update Vehicle Attribute***");
            System.out.println("[1] Make");
            System.out.println("[2] Model");
            System.out.println("[3] Color");
            System.out.println("[4] Year");
            System.out.println("[5] Mileage");
            System.out.println("[6] Price");
            
            System.out.print("Enter the number for the attribute to update: ");
            selection = s.nextInt();
            System.out.print("Enter the new value (Current: ");
            switch (selection) {
               case 1 :
                  System.out.print(currentAuto.getMake() + "): ");
                  String newMake = s.next();
                  updateAttribute(vin, "make", newMake);
                  break;
               case 2 :
                  System.out.print(currentAuto.getModel() + "): ");
                  String newModel = s.next();
                  updateAttribute(vin, "model", newModel);
                  break;
               case 3 :
                  System.out.print(currentAuto.getColor() + "): ");
                  String newColor = s.next();
                  updateAttribute(vin, "color", newColor);
                  break;
               case 4 :
                  System.out.print(currentAuto.getYear() + "): ");
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
                  System.out.print(currentAuto.getMileage() + "): ");
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
                  System.out.print(currentAuto.getPrice() + "): ");
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
            Automobile returnAuto = dealerInventory.get(vinIndex);
            return returnAuto;
         } else {
            System.out.println("\nCould not find VIN: " + vin);
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
            System.out.println();
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
         System.out.println("Saved to " + file.getAbsolutePath());
      } catch (Exception e) {
         if (e.getMessage() != null) {
            System.out.println(e.getMessage());   
         } else {
            System.out.println("ERROR: There was a problem saving to file.");
         }
      } finally {
         if (filePrinter != null) {
            filePrinter.close();
         }
      }

   }
   
   public void savePrompt() {
      String fileName = "";
      Scanner s = new Scanner(System.in);
      System.out.print("Enter the filename to save [Press enter to use \"inventory.txt\"]: ");
      fileName = s.nextLine();
      if (fileName.isEmpty()) {
         fileName = "inventory.txt";
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

   public void backToMenu(){
      Scanner s = new Scanner(System.in);
      String c = "0";
      System.out.println("Press Enter/Return to return to the main menu.");
      while (!c.isEmpty()) {
         c = s.nextLine();
         c = "";
     }
   }
   
   public static void main(String[] args) throws IOException {   
      // Instantiate a DealerInventory object
      DealerInventory myInventory = new DealerInventory();
      
      // For demonstration purposes: Populate sample data
      myInventory.dealerInventory.add(new Automobile("AAAA", "Toyota", "86", "Red", 2020, 20000, new BigDecimal(20000)));
      myInventory.dealerInventory.add(new Automobile("BBBB", "Honda", "Civic", "Blue", 2021, 16000, new BigDecimal(23000)));
      
      // Declare variables to be used in user menu
      Automobile returnedAuto;
      Automobile currentAuto;
      String currentVin;
      int menuSelector;
      Scanner s;
      
      // Simple user menu loop
      do {
         returnedAuto = null;
         s = new Scanner(System.in);
         
         // Print the menu each time the loop begins
         System.out.println("***Dealership Inventory***");
         System.out.println("[1] Add Vehicle");
         System.out.println("[2] Remove Vehicle");
         System.out.println("[3] Update Vehicle Details");
         System.out.println("[4] Show Single Vehicle");
         System.out.println("[5] Show All Vehicles");
         System.out.println("[6] Save Vehicle List to File");
         System.out.println("[7] Exit");
         System.out.println();
         
         // Request user input for the menu selection
         System.out.print("Enter the number of your selection (1-7): ");
         menuSelector = 0;
         try {
            menuSelector = s.nextInt();
         } catch (Exception e) {
            System.out.println();
            System.out.println("You did not enter a valid option.");
            continue;
         }
         
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
               if (returnedAuto != null) {
                  System.out.println("Automobile details:");
                  myInventory.printAutomobile(returnedAuto.getVin());   
               }
               break;
            case 4 :
               System.out.print("Enter the VIN to display: ");
               currentVin  = s.next();
               myInventory.printAutomobile(currentVin);
               myInventory.backToMenu();
               break;
            case 5 :
               System.out.println("Dealer Inventory Report");
               System.out.println();
               for (int i = 0; i < myInventory.dealerInventory.size(); i++) {
                  currentAuto = myInventory.dealerInventory.get(i);
                  myInventory.printAutomobile(currentAuto.getVin());
               }
               System.out.println();
               myInventory.backToMenu();
               break;
            case 6 :
               myInventory.savePrompt();
               break;
            case 7 :
               System.out.print("Would you like to save a copy of your inventory first? [Y/N]: ");
               String saveConfirm = s.next();
               switch (saveConfirm.toLowerCase()) {
                  case "y" : 
                     myInventory.savePrompt();
                     System.out.println("Exiting. Thank you for using the program!");
                     break;
                  case "n" :
                     System.out.println("Exiting. Thank you for using the program!");
                     break;
                  default :
                     System.out.println("Invalid option. Returning to menu.");
                     menuSelector = -1;
               }
               break;
             default :
                System.out.println();
                System.out.println("You did not enter a valid option.");
         } 
         
      }
      while (menuSelector != 7);
      
      s.close();
   }

}
