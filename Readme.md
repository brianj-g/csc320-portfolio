
# Readme for the Automobile Dealership Inventory Management Program

## Overview

This program is designed to manage an automobile dealership's inventory. It allows for the storage, update, and retrieval of automobile information within a dealership's inventory system. The program consists of two main components: the `Automobile` class, which defines the structure and capabilities of an automobile object, and the `DealerInventory` class, which manages a list of `Automobile` objects.

## Features

- **Automobile Class:** Represents an automobile with attributes such as Vehicle Identification Number (VIN), make, model, color, year, mileage, and price. Provides methods to set and get the attributes of an automobile.
- **DealerInventory Class:** Manages the dealership's inventory of automobiles. Supports adding new automobiles to the inventory, updating existing automobile attributes, and listing automobiles within the inventory.

## Functionality

- **Add Automobiles:** Users can add new automobile objects to the dealership's inventory with detailed attributes.
- **Update Automobile Attributes:** Allows for the update of specific attributes of an automobile, such as price or mileage, based on user input.
- **List Automobiles:** Users can list all automobiles in the inventory or retrieve detailed information about a specific automobile.
- **Save Inventory:** Users can export the entire inventory to a text file of their choice.

## Compiling and Running the Program

1. Save the `Automobile.java` and `DealerInventory.java` files in the same directory.
2. Open a terminal or command prompt.
3. Navigate to the directory where the files are saved.
4. Compile the program using the Java compiler:
   - `javac Automobile.java DealerInventory.java`
5. Run the compiled `DealerInventory` class:
   - `java DealerInventory`
6. Follow the on-screen prompts to interact with the program.

