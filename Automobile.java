/**
 * This class represents a basic automobile with information that may be used for identification, searching,
 * sorting, and listing of objects.
 * @author Brian Gunther
 * @version 1.0
 */

// BigDecimal will be used for any potential financial calculations
import java.math.BigDecimal;
import java.time.Year;

public class Automobile {
   private String vin;
   private String make;
   private String model;
   private String color;
   private int year;
   private int mileage;
   private BigDecimal price;
   
   /**
    * Parameterized constructor
    * @param vin
    * @param make
    * @param model
    * @param color
    * @param year
    * @param mileage
    * @param price
    */
   public Automobile(String vin, String make, String model, String color, int year, int mileage, BigDecimal price){
      this.vin = vin;
      this.make = make;
      this.model = model;
      this.color = color;
      // Perform basic validation for year. This could be varied based on the dealership's inventory focus.
      if (year > 1970 && year <= Year.now().getValue() + 1) {
         this.year = year;
      } else {
         throw new IllegalArgumentException("Invalid year: " + year);
      }
      // Ensure a zero or positive mileage is entered
      if (mileage >= 0) {
         this.mileage = mileage;
      } else {
         throw new IllegalArgumentException("Invalid mileage: " + mileage);
      }
      // Ensure a positive dollar amount is entered
      if (price.compareTo(new BigDecimal(0)) == 1) {
         this.price = price;
      } else {
         throw new IllegalArgumentException("Invalid price: " + price);
      }

   }

   /**
    * Default constructor
    */
   public Automobile(){
      this.vin = "";
      this.make = "";
      this.model = "";
      this.color = "";
      this.year = -1;
      this.mileage = -1;
      this.price = new BigDecimal(-1);
   }
   
   /**
    * Set the private vin field to parameter value
    * @param vin
    */
   public void setVin(String vin) {
      this.vin = vin;
   }
   
   /**
    * Set the private make field to parameter value
    * @param make
    */
   public void setMake(String make) {
      this.make = make;
   }
   
   /**
    * Set the private model field to parameter value
    * @param model
    */
   public void setModel(String model) {
      this.model = model;
   }
   
   
   /**
    * Set the private color field to parameter value
    * @param color
    */
   public void setColor(String color) {
      this.color = color;
   }
   
   /**
    * Set the private year field to parameter value
    * @param year
    */
   public void setYear(int year) {
      this.year = year;
   }
   
   /**
    * Set the private mileage field to parameter value
    * @param mileage
    */
   public void setMileage(int mileage) {
      this.mileage = mileage;
   }
   
   /**
    * Set the private price field to parameter value
    * @param price
    */
   public void setPrice(BigDecimal price) {
      this.price = price;
   }
   
   /**
    * Return the private vin field
    */
   public String getVin() {
      return this.vin;
   }
   
   /**
    * Return the private make field
    */
   public String getMake() {
      return this.make;
   }
   
   /**
    * Return the private model field 
    */
   public String getModel() {
      return this.model;
   }
   
   /**
    * Return the private color field
    */
   public String getColor() {
      return this.color;
   }
   
   /**
    * Return the private year field
    */
   public int getYear() {
      return this.year;
   }
   
   /**
    * Return the private mileage field
    */
   public int getMileage() {
      return this.mileage;
   }
   
   /**
    * Return the private price field
    */
   public BigDecimal getPrice() {
      return this.price;
   }

   /**
    * Return a String array represting the attributes of the object
    */
   public String[] listAutomobile() {
      String[] attributes = new String[7];
      attributes[0] = "VIN: " + this.vin;
      attributes[1] = "Make: " + this.make;
      attributes[2] = "Model: " + this.model;
      attributes[3] = "Color: " + this.color;
      attributes[4] = "Year: " + this.year;
      attributes[5] = "Mileage: " + this.mileage;
      attributes[6] = "Price: " + this.price;
      
      return attributes;
   }
}