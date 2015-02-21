/*<listing chapter="2" section="3" sequence="1">*/
//package KW.CH02; // Is this important?

import java.util.Arrays;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class implements some of the methods of the Java
 *  ArrayList class.
 *  @author Koffman & Wolfgang
 */
public class KWArrayList<E>
        /*<exercise chapter="2" section="9" type="programming" number="1">*/
        extends AbstractList<E>
        /*</exercise>*/
{
    // Data Fields

    /** The default initial capacity */
    private static final int INITIAL_CAPACITY = 10;
    /** The underlying data array */
    private E[] theData;
    /** The current size */
    private int size = 0;
    /** The current capacity */
    private int capacity = 0;

    /**
     * Construct an empty KWArrayList with the default
     * initial capacity
     */
    public KWArrayList() {
        capacity = INITIAL_CAPACITY;
        theData = (E[]) new Object[capacity];
    }



    /**
     * Add an entry to the data inserting it before the
     * item at the specified index.
     * @param index - The index of the time that the new
     *        value it to be inserted in front of.
     * @param theValue - The value to be inserted
     * @throws ArrayIndexOUtOfBoundsException if index is
     *         less than zero or greater than size
     */
    public boolean add(E anEntry) {
        if (size == capacity) {
            reallocate();
        }
        theData[size] = anEntry;
        size++;
        return true;
    }

    /**
     * Get a value in the array based on its index.
     * @param index - The index of the item desired
     * @return The contents of the array at that index
     * @throws ArrayIndexOutOfBoundsException - if the index
     *         is negative or if it is greater than or equal to the
     *         current size
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }

    /**
     * Set the value in the array based on its index.
     * @param index - The index of the item desired
     * @param newValue - The new value to store at this position
     * @return The old value at this position
     * @throws ArrayIndexOutOfBoundsException - if the index
     *         is negative or if it is greater than or equal to the
     *         current size
     */
    public E set(int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;
    }

    /**
     * Remove an entry based on its index
     * @param index - The index of the entry to be removed
     * @return The value removed
     * @throws ArrayIndexOutOfBoundsException - if the index
     *         is negative or if it is greater than or equal to the
     *         current size
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E returnValue = theData[index];
        for (int i = index + 1; i < size; i++) {
            theData[i - 1] = theData[i];
        }
        size--;
        return returnValue;
    }

    /**
     * Allocate a new array to hold the directory
     */
    private void reallocate() {
        capacity = 2 * capacity;
        theData = Arrays.copyOf(theData, capacity);
    }

    /**
     * Get the current size of the array
     * @return The current size of the array
     */
    public int size() {
        return size;
    }

    //HW #1 STARTS HERE =======================================================

    /**
     * Construct an empty KWArrayList with a specified initial capacity
     * @param capacity The initial capacity
     */
    public KWArrayList(int capacity) {
        theData = (E[]) new Object[capacity];
    }


    /**
     * Returns the index of the first occurence of the specified element
     * in this list, or -1 if this list does not contain the element
     * @param item The object to search for
     * @returns The index of the first occurence of the specified item
     *          or -1 if this list does not contain the element
     */
    public int indexOf(Object item) {
        int Index = -1;
        for (int i = 0; (i < theData.length && Index == -1); i++) {
            if (theData[i] == item) {
                Index = i;
            }
        }
        return Index;
    }

    public static void reverse(ArrayList l){
        if (l.size() > 1) {
            Object val = l.remove(0);
            reverse(l);
            l.add(val);
        }

        // Couldn't we just call Collections.reverse(l)??
    }

    public static void remove(ArrayList l, Object target){
        Iterator<Integer> i = l.iterator();

        while (i.hasNext()) {
            Integer thisObj = i.next();
            if (thisObj == target) {
                l.remove(thisObj);
            }
        }
    }

    public static ArrayList<Integer> arrayDouble(ArrayList<Integer> l){
        ArrayList<Integer> thisL = new ArrayList<Integer>();
        for (Integer i : l) {
            Integer thisInt = i;
            thisL.add(new Integer(i * 2));
        }
        return thisL;
    }

    public static void main(String[] args){
        //test your methods here to make sure they work.
        KWArrayList<Integer> l = new KWArrayList();
        l.add(5);
        System.out.println("Current KWArrayList: " + l);

        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        al.add(3);

        System.out.println("Starting ArrayList: " + al);

        reverse(al);

        System.out.println("Reversed ArrayList: " + al);

        arrayDouble(al);

        System.out.println("Reversed & Doubled ArrayList: " + al);

        remove(al, 3);

        System.out.println("Arraylist with (int)3 removed: " + al);

    }
}
/*</listing>*/