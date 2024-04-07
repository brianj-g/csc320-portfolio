
# Print Address Program Documentation
# Portfolio Corrections

## CSC320 - CTA Module 1 (Brian Gunther)

## Objective
Print the name and address of a fictitious person.

## Description
This program stores name and address attributes in string variables and subsequently prints them to standard output in a mailing address format.

### Portfolio Project Corrections
There were no required corrections to this program for the portfolio submission

## Program Code

```java
/*
 * Objective:       Print the name and address of a fictitious person
 * Description:     This program stores name and address attributes in string variables
 *                  and subsequently prints them to standard output in a mailing address format.
 */

public class PrintAddress {

    public static void main(String[] args) {
        // Define variables as the String type
        String firstName, lastName, streetAddress, city, state, zipCode;
        
        // Assign values to string variables
        firstName = "Mickey";
        lastName = "Mouse";
        streetAddress = "1313 Disneyland Dr";
        city = "Anaheim";
        state = "CA";
        zipCode = "92802";
        
        // Print strings to standard output, formatted as an address
        System.out.println(firstName + " " + lastName);
        System.out.println(streetAddress);
        System.out.println(city + ", " + state + " " + zipCode);
    }

}
```

## Expected Output
When executed, the program will print the following output to the standard console:

```
Mickey Mouse
1313 Disneyland Dr
Anaheim, CA 92802
```
