
/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 09/19/22
 * Submitted:  09/19/22
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: William Carr
 * @version: 2023.09.19
 */

public class ListArrayBasedPlus extends ListArrayBased {

    /**
     * Returns a String version of the items in the list separated by a space
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < numItems; i++) {
            result.append(((i == 0) ? "" : " ") + items[i]);
        }
        return result.toString();
    }

    /**
     * Reverses the list in the superclass
     */
    public void reverse() {
        for(int i = 0; i < numItems/2; i ++) {
            Object temp = items[i];
            items[i] = items[numItems-1-i];
            items[numItems-1-i] = temp;
        }
    }

    public void add(int index, Object item) {
        resize(); // will check if it's needed anyways
        super.add(index, item);
    }

    /**
     * Doubles the size of the items field when the list reaches its max
     */
    public void resize() {
        int currentLen = items.length;
        if(numItems == currentLen) { // if max is reached
            Object[] tempItems = new Object[currentLen*2];
            for(int i = 0; i < numItems; i++) {
                tempItems[i] = items[i];
            }
            //after transferring data to items, move it into items
            items = tempItems;
        }
    }
}