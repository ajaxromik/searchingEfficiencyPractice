import java.io.*;

/*
 * Purpose: Data Structure and Algorithms Lab 8 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 11/07/22
 * Submitted:  11/07/22
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: William Carr
 * @version: 2023.11.07
 */

public class Lab8P1Driver {
    
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        ListArrayBasedPlus myList = new ListArrayBasedPlus();

        System.out.println("Select from the following menu:\n"
                           +"\t0. Exit program\n"
                           +"\t1. Insert item into the list\n"
                           +"\t2. Remove item from the list\n"
                           +"\t3. Get item from the list\n"
                           +"\t4. Search for a specific item in the list\n"
                           +"\t5. Clear the list\n"
                           +"\t6. Print size and content of the list\n");

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
                getFromList(myList);
                break;
            case 4:
                searchList(myList);
                break;
            case 5:
                emptyList(myList);
                break;
            case 6:
                printList(myList);
                break;
            default: // continuing unless told to stop
                continuing = false;
                System.out.println("Exiting program... Goodbye!");
                break;
            }

        } while(continuing);

    }

    /**
     * Searches for an item in the list that is equal to the key.
     * 
     * @param list the list to search the item for
     * @return An integer that represents the index where an item 
     * was found. If no item was found, returns -1
     */
    public static int search(String key, ListArrayBasedPlus list) {
        int len = list.size();
        for(int i = 0; i < len; i++) {
            int compare = key.compareTo((String)list.get(i));
            if(compare == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void searchList(ListArrayBasedPlus list) throws IOException{
        System.out.print("You are now searching for an item"+
                         " on the list.\n\tEnter item: ");
        String itemName = stdin.readLine().trim();
        System.out.println(itemName);

        int result = search(itemName, list);
        if(result == -1) {
            System.out.printf("The item was not found in the list%n%n");
        } else {
            System.out.printf("The item was found at %d%n%n", result);
        }
    }

    public static void addToList(ListInterface list) throws IOException{
        System.out.print("You are now inserting an item"+
                         " into the list.\n\tEnter item: ");
        String itemName = stdin.readLine().trim();
        System.out.println(itemName);

        System.out.print("\tEnter position to insert item in: ");
        int position = Integer.parseInt(stdin.readLine().trim());
        System.out.println(position);
        if(position < 0 || position > list.size())
            System.out.println("Position specified is out of range!\n");
        else {
            list.add(position, itemName);
            System.out.printf("Item %s inserted into"+
                              " position %d in the list.%n%n", itemName, position);
        }
    }

    public static void removeFromList(ListInterface list) throws IOException{
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

    public static void getFromList(ListInterface list) throws IOException{
        System.out.print("\tEnter position to retrieve item from: ");
        int position = Integer.parseInt(stdin.readLine().trim());
        System.out.println(position);
        if(position < 0 || position >= list.size())
            System.out.println("Position specified is out of range!\n");
        else {
            System.out.printf("Item %s retrieved from"+
                              " position %d in the list.%n%n", list.get(position).toString(), position);
        }
    }

    public static void emptyList(ListInterface list) {
        list.removeAll();
        System.out.println();
    }

    /**
     * Prints list after checking for null/empty
     * @param list
     */
    public static void printList(ListInterface list) {
        if(list == null || list.size() == 0)
            System.out.println("\tList is empty.\n");
        else
            System.out.printf("\tList of size %d has the following items: %s%n%n",
                              list.size(), list.toString());
    }

    public static void reverseList(ListArrayBasedPlus list) {
        list.reverse();
        System.out.println("List reversed\n");
    }

}