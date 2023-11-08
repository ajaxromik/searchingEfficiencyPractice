public interface AscendinglyOrderedStringListInterface 
{ public boolean isEmpty();
  public int size();
  public void add(String item) throws ListIndexOutOfBoundsException;
  public String get(int index) throws ListIndexOutOfBoundsException;
  public String remove(int index) throws ListIndexOutOfBoundsException;
  public int search(String key);
  public void removeAll();
} 