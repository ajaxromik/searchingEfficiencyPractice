import java.io.*;

/**
 * Purpose: Data Structure and Algorithms Lab 8 Problem 3
 * Status: Complete and thoroughly tested
 * Last update: 11/07/22
 * Submitted:  11/07/22
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: William Carr
 * @version: 2023.11.07
 */

public class Lab8P3Driver {
    
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        AscendinglyOrderedStringList myList = new AscendinglyOrderedStringList();

        System.out.println("Select from the following menu:\n"
                           +"\t0. Exit program\n"
                           +"\t1. Insert specified item into the list\n"
                           +"\t2. Remove item from the list\n"
                           +"\t3. Search list for a specified item\n"
                           +"\t4. Clear the list\n"
                           +"\t5. Print size and content of the list\n");

        int selection;
        boolean continuing = true;
        do {

            System.out.print("Make your menu selection now: ");
            selection = Integer.parseInt(stdin.readLine().trim());
            System.out.println(selection);

            switch(selection) {
            case 1:
                addToList(myList);
                break;
            case 2:
                removeFromList(myList);
                break;
            case 3:
                searchList(myList);
                break;
            case 4:
                emptyList(myList);
                break;
            case 5:
                printList(myList);
                break;
            default: // continuing unless told to stop
                continuing = false;
                System.out.println("Exiting program... Goodbye!");
                break;
            }

        } while(continuing);

    }

    public static void searchList(AscendinglyOrderedStringList list) throws IOException{
        System.out.print("You are now searching for an item"+
                         " on the list.\n\tEnter item: ");
        String itemName = stdin.readLine().trim();
        System.out.println(itemName);

        int result = list.search(itemName);
        if(result < 0) {
            System.out.printf("The item was not found in the list%n%n");
        } else {
            System.out.printf("The item was found at %d%n%n", result);
        }
    }

    public static void addToList(AscendinglyOrderedStringListInterface list) throws IOException{
        System.out.print("You are now inserting an item"+
                         " into the list.\n\tEnter item: ");
        String itemName = stdin.readLine().trim();
        System.out.println(itemName);

        int position = (list.size() > 0) ? list.search(itemName) : -1;
        if(position < 0) {
            list.add(itemName);
            System.out.printf("Item %s inserted into"+
                          " the list.%n%n", 
                          itemName);
        } else {
            System.out.println("The item is already in the list.\n");
        }
    }

    public static void removeFromList(AscendinglyOrderedStringListInterface list) throws IOException{
        System.out.print("\tEnter position to remove item from: ");
        int position = Integer.parseInt(stdin.readLine().trim());
        System.out.println(position);
        if(position < 0 || position >= list.size())
            System.out.println("Position specified is out of range!\n");
        else {
            System.out.printf("Item %s removed from"+
                                " position %d in the list.%n%n", list.remove(position).toString(), position);
        }
    }

    public static void emptyList(AscendinglyOrderedStringListInterface list) {
        list.removeAll();
        System.out.println();
    }

    /**
     * Prints list after checking for null/empty
     * @param list
     */
    public static void printList(AscendinglyOrderedStringListInterface list) {
        if(list == null || list.size() == 0)
            System.out.println("\tList is empty.\n");
        else
            System.out.printf("\tList of size %d has the following items: %s%n%n",
                              list.size(), list.toString());
    }

}