/**
 * This class represents a basic automobile with information that may be used for identification, searching,
 * sorting, and listing of objects.
 * @author Brian Gunther
 * @version 1.0
 */

// BigDecimal will be used for any potential financial calculations
import java.math.BigDecimal;

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
      this.year = year;
      this.mileage = mileage;
      this.price = price;
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
    * @param vin
    */
   public String getVin(String vin) {
      return this.vin;
   }
   
   /**
    * Return the private make field
    * @param make
    */
   public String getMake(String make) {
      return this.make;
   }
   
   /**
    * Return the private model field 
    * @param model
    */
   public String getModel(String model) {
      return this.model;
   }
   
   /**
    * Return the private color field
    * @param color
    */
   public String getColor(String color) {
      return this.color;
   }
   
   /**
    * Return the private year field
    * @param year
    */
   public int getYear(int year) {
      return this.year;
   }
   
   /**
    * Return the private mileage field
    * @param mileage
    */
   public int getMileage(int mileage) {
      return this.mileage;
   }
   
   /**
    * Return the private price field
    * @param price
    */
   public BigDecimal getPrice(BigDecimal price) {
      return this.price;
   }

   /**
    * Print out the attributes of the object
    */
   public void printAutomobile() {
      System.out.println("VIN: " + vin);
      System.out.println("Make: " + make);
      System.out.println("Model: " + model);
      System.out.println("Color: " + color);
      System.out.println("Year: " + year);
      System.out.println("Mileage: " + mileage);
      System.out.println("Price: " + price);
   }
   
   
}