
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

public class AscendinglyOrderedStringList implements AscendinglyOrderedStringListInterface {

    private String []items;
    private int numItems;

    /**
     * Creates an instance of the AscendinglyOrderedStringList class.
     */
    public AscendinglyOrderedStringList() {
    	items = new String[3];
    	numItems = 0;
    }

    /**
     * Returns whether the list is empty
     * @return true if the list is empty; otherwise, false
     */
	public boolean isEmpty(){
		return (numItems == 0);
	}

	/**
	 * Returns the size of the list
	 * @return The length of the list
	 */
	public int size(){
		return numItems;
	}

	/**
     * Doubles the size of the items field when the list reaches its max
     */
    private void resize() {
        int currentLen = items.length;
        if(numItems == currentLen) { // if max is reached
            String[] tempItems = new String[currentLen*2];
            for(int i = 0; i < numItems; i++) {
                tempItems[i] = items[i];
            }
            //after transferring data to items, move it into items
            items = tempItems;
        }
    }

	/**
	 * Searches for an item in an that is equal to the key. If the list 
	 * does not contain the key, the method will return a negative 
	 * number that will be the index where the item would fit into 
	 * the list but minus (length + 1)
	 * Precondition: The list must not be empty
     * 
     * @param key A key to use for searching with the compareTo method
     * @return An integer that represents the index where an item 
     *  was found. If no item was found, returns the index minus
     *  the list length + 1.
	 */
	public int search(String key){
		int low = 0, mid;
		int high = numItems - 1;
		while(low < high) {
			
			mid = (low+high)/2;

			if(key.compareTo(items[mid]) > 0)
				low = mid + 1;
			else
				high = mid;
		}
		// low and high are equal and the range is 1 at this point
		int comparison = key.compareTo(items[low]);
		if (comparison == 0) 
			return low;
		else //the list does not have the item
			//if it's the last index, return the one after it
			return (comparison > 0) ? 
				  (high - numItems) : low-1-numItems;
	}

	/**
	 * Adds an item to the list in the spot it fits into ascending order.
	 * 
	 * @param item The item to add to the list
	 */
	public void add(String item) throws ListIndexOutOfBoundsException{
		resize();
		int index = (numItems > 0) ? search(item) : -1;
        if (index < 0 && index >= -1-numItems)
        {
            // shifts items to make space at index
            index += 1 + numItems;
            for (int pos = numItems-1; pos >= index; pos--)
            {
                items[pos+1] = items[pos];
            }

            items[index] = item;
            numItems++;
        }
        else if (index >= 0 && index <= numItems)
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on add");
        }
	}

	/**
	 * Returns the string from the list at the specified index
	 * 
	 * @param index The integer index of the String to return.
	 * @return The string from that index.
	 */
	public String get(int index) throws ListIndexOutOfBoundsException{
		if (index >= 0 && index < numItems)
        {
            return items[index];
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on get");
        }
	}

	/**
	 * Removes a String at a specific index and returns it.
	 * 
	 * @param index The index of the String to remove.
	 * @return The string that was removed from that index.
	 */
	public String remove(int index) throws ListIndexOutOfBoundsException{
		String result;
        if (index >= 0 && index < numItems)
        {
            result = items[index];
            for (int pos = index+1; pos < numItems; pos++) 
            {
                items[pos-1] = items[pos];
            }
            numItems--;
            items[numItems] = null;
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on remove");
        }  // end if
        return result;
	}

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
	 * Removes everything in the list
	 */
	public void removeAll(){
		items = new String[3];
    	numItems = 0;
	}


}