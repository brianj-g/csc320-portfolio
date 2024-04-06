/**
 * Portfolio Project: Dealer Automobile Inventory
 * Brian Gunther
 * Colorado State University Global
 * CSC320: Programming I
 * Dr. Gonzalez
 * April 7, 2024
 * 
 * Overview: This program functions as a basic inventory program for a car dealership.
 * It uses a class for instantiation of invidivual automobile objects, and a class with user interface
 * methods and the main program.
 */

import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class provides the main program method and a variety of user interface methods to create, 
 * modify, store, and remove objects from an ArrayList. This also provides mechanisms to print
 * and save the ArrayList contents to a file.
 */
public class DealerInventory {
   
   /**
    * ArrayList to keep inventory
    */
   private ArrayList<Automobile> dealerInventory = new ArrayList<Automobile>();
   
   /**
    * Checks the ArrayList for presence of an object with specified VIN. 
    * @param vin
    * @return integer representing the index in the ArrayList, or -1 if not found
    */
   public int checkInventory(String vin) {
      for (int i = 0; i < dealerInventory.size(); i++) {
         if (vin.compareTo(dealerInventory.get(i).getVin()) == 0) {
            return i;
         }
      }
      return -1;
   }

   /**
    * Method to add an automobile object to inventory
    * @param vin
    * @param make
    * @param model
    * @param color
    * @param year
    * @param mileage
    * @param price
    * @return Automobile reference to the newly created object, or null if unable to create
    */
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

   /**
    *  User input method for adding automobile
    * @return Automobile from the addAutomobile method
    */
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
      
      // Make, Model, and Color will loop until a string is entered.
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
      
      /**
       * Numeric data types year, mileage, and price require handling to ensure the correct data type
       * is entered. These will loop until appropriate data is detected.
       */
      int year = -1;
      boolean validYear = false;
      do {
         System.out.print("Year (e.g., 2024): ");
         String lineInput = s.nextLine();
         // Top of loop if blank line
         if ("".equals(lineInput)) {
            System.out.println("Invalid input. Please enter the year as an integer.");
         } else {
            try {
               // Attempts to locate integer in the input string. Throws exception if this fails.
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
         // Top of loop if blank line
         if ("".equals(lineInput)) {
            System.out.println("Invalid input. Please enter the mileage as an integer.");
         } else {
            try {
               // Attempts to locate integer in the input string. Throws exception if this fails.
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
         // Top of loop if blank line
         if ("".equals(lineInput)) {
            System.out.println("Invalid input. Please enter a valid price.");
         } else {
            try {
               // Attempts to convert the input to a BigDecimal. Exception thrown if this fails.
               price = new BigDecimal(lineInput);
               validPrice = true;
            } catch (Exception e) {
               System.out.println("Invalid input. Please enter a valid price.");
            }
         }
      } while (!validPrice); 
      
      return addAutomobile(vin, make, model, color, year, mileage, price);
   }
   
   /**
    *  Method to remove an automobile from inventory (based on VIN)
    * @param vin
    * @return true if successfully removed; false if the operation fails.
    */
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

   /**
    *  Method to find a particular vehicle and return the Automobile object
    * @param vin
    * @return Returns Automobile object that was located, or null if not found
    */
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
   
   /**
    *  Method to update a vehicle's *String* attributes
    * @param vin
    * @param attribute
    * @param value
    * @return Returns updated Automobile object, or null if unable to update.
    */
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
   
   /**
    *  Method (overload) to update a vehicle's numerical attributes
    * @param vin
    * @param attribute
    * @param value
    * @return Returns updated Automobile object, or null if unable to update.
    */
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
   
   /**
    *  Method (overload) to update the vehicle's price
    * @param vin
    * @param attribute
    * @param value
    * @return Returns updated Automobile object, or null if unable to update.
    */
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
   
   /**
    *  User input method for updating attributes
    * @param vin
    * @return Returns updated Automobile object, or null if unable to update.
    */
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
            
            // Request user input for the menu selection
            selection = 0;
            // Basic validation for input range between 1 and 6
            while (selection < 1 || selection > 6) {
               try {
                  System.out.print("Enter the number of your selection (1-6): ");
                  selection = s.nextInt();
                  if (selection < 1 || selection > 6) {
                     throw new Exception("You did not enter a valid option");
                  }
               } catch (Exception e) {
                  System.out.println();
                  System.out.println("You did not enter a valid option.");
                  selection = 0;
               }
            }
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

            return currentAuto;
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
   
   /**
    *  Method to print an object to screen
    * @param vin
    */
   public void printAutomobile(String vin) {
      String[] retrievedAuto;
      
      try {
         int vinIndex = checkInventory(vin);
         
         if(vinIndex >= 0) {
            // Uses the array from the object's listAutomobile method
            retrievedAuto = dealerInventory.get(vinIndex).listAutomobile();
            for (int i = 0; i < retrievedAuto.length; i++) {
               // Print each element to screen
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
   
   /**
    *  Method to print full inventory to a file
    * @param fileName can be any string. If it contains path delineators (e.g., "/") 
    * then the path will be updated.
    * @throws IOException to accomodate a variety of general issues with file operations.
    */
   public void saveAll(String fileName) throws IOException {
      String[] retrievedAuto;
      FileOutputStream fileStream = null;
      PrintWriter filePrinter = null;
      
      // creates a File object from the filename so that the full path can be displayed
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
                  // Prints each element in the listAutomobile() to file, for each object in the ArrayList
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
         // For better user experience, the full path is printed after saving
         System.out.println("Saved to " + file.getAbsolutePath());
      } catch (Exception e) {
         if (e.getMessage() != null) {
            System.out.println(e.getMessage());   
         } else {
            System.out.println("ERROR: There was a problem saving to file.");
         }
      } finally {
         // This null check must be done prior to closing the object to avoid errors if the FileOutputStream
         // object is nullified due to a read-only path, etc.
         if (filePrinter != null) {
            filePrinter.close();
         }
      }

   }
   
   /**
    * Method to prompt the user for a file name, with input validation and exception handling
    */
   public void savePrompt() {
      String fileName = "";
      Scanner s = new Scanner(System.in);
      System.out.print("Enter the filename to save [Press enter to use \"inventory.txt\"]: ");
      fileName = s.nextLine();
      if (fileName.isEmpty()) {
         // If the user doesn't type anything, use a default filename
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

   /**
    * Method to create a pause in the program after the user calls a printed report
    */
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
               // Add an object
               returnedAuto = myInventory.addAutomobileUserInput();
               if (null != returnedAuto) {
                  System.out.println();
                  System.out.println("You added a new vehicle:");
                  myInventory.printAutomobile(returnedAuto.getVin());
               } else {
                  // If null was returned, let the user know the object was not added
                  System.out.println("Vehicle was not added.");
               }
               break;
            case 2 :
               // Remove an object
               System.out.print("Enter the VIN to remove: ");
               if (myInventory.removeAutomobile(s.next())) {
                  System.out.println("Vehicle was removed.");
               }
               break;
            case 3 :
               // Update a single attribute
               System.out.print("Enter the VIN to update: ");
               currentVin = s.next();
               returnedAuto = myInventory.updateAttributeUserInput(currentVin);
               if (returnedAuto != null) {
                  System.out.println("Automobile details:");
                  myInventory.printAutomobile(returnedAuto.getVin());   
               }
               // A null return is handled upstream by the user input method
               break;
            case 4 :
               // Print a single object to screen
               System.out.print("Enter the VIN to display: ");
               currentVin  = s.next();
               myInventory.printAutomobile(currentVin);
               // Call a pause to allow the user to read the screen before returning to menu
               myInventory.backToMenu();
               break;
            case 5 :
               // Print all objects to screen
               System.out.println("Dealer Inventory Report");
               System.out.println();
               for (int i = 0; i < myInventory.dealerInventory.size(); i++) {
                  currentAuto = myInventory.dealerInventory.get(i);
                  myInventory.printAutomobile(currentAuto.getVin());
               }
               System.out.println();
               // Call a pause to allow the user to read the screen before returning to menu
               myInventory.backToMenu();
               break;
            case 6 :
               // Save to file. All operations are handled by the called method.
               myInventory.savePrompt();
               break;
            case 7 :
               // Exit program, with user-friendly reminder to save before exiting.
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
