import java.util.Arrays;


/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Matthew Freestone (maf0083@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  1/23/2021
*
*/
public final class Selector {

    /**
     * Can't instantiate this class.
     *
     * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
     *
     */
    private Selector() { }


    /**
     * Selects the minimum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int min(int[] a) {
        if (a == null || a.length == 0){
            throw new IllegalArgumentException();
        }
        int min = a[0];
        for (int x: a){
            if (x < min){
                min=x;
            }
        }
        return min;
    }


    /**
     * Selects the maximum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int max(int[] a) {
        if (a == null || a.length == 0){
            throw new IllegalArgumentException();
        }
        int max = a[0];
        for (int x: a){
            if (x > max){
                max=x;
            }
        }
        return max;
    }


    /**
     * Selects the kth minimum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth minimum value. Note that there is no kth
     * minimum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */
    public static int kmin(int[] a, int k) {
        if (a == null || a.length == 0 || k < 1 || k > a.length){
            throw new IllegalArgumentException();
        }
        if (k == 1){
            return min(a); //speed trick 
        }
        int[] sort_min = a.clone();
        Arrays.sort(sort_min);

        return findUniqueFromStart(sort_min, k);
    }


    /**
     * Selects the kth maximum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth maximum value. Note that there is no kth
     * maximum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */
    public static int kmax(int[] a, int k) {
        if (a == null || a.length == 0 || k < 1 || k > a.length){
            throw new IllegalArgumentException();
        }
        if (k == 1){
            return max(a); //speed trick 
        }
        int[] sort_min = a.clone();
        Arrays.sort(sort_min);
        

        int[] sort_max = reversedArray(sort_min);
        // int[] sort_max = new int[sort_min.length];
        // int j = 0;
        // for (int i = (sort_min.length - 1); i >= 0; i--, j++){ //reverse array
        //     sort_max[j] = sort_min[i];
        // }

        return findUniqueFromStart(sort_max, k);
    }

    private static int findUniqueFromStart(int[] a, int k){
        int numUnique = 1;
        int out = a[0];
        for (int i = 1; i < a.length && numUnique != k; i++){ //look through array until youre at the end or get to the kth unique
            if (a[i] != a[i-1]){
                numUnique++; //if its not a repeat num, advance unique count up 
                out = a[i]; //update current val
            }
        }
        if (k > numUnique){ //TODO TEST this 
            throw new IllegalArgumentException();
        }
        return out;
    }


    /**
     * Returns an array containing all the values in a in the
     * range [low..high]; that is, all the values that are greater
     * than or equal to low and less than or equal to high,
     * including duplicate values. The length of the returned array
     * is the same as the number of values in the range [low..high].
     * If there are no qualifying values, this method returns a
     * zero-length array. Note that low and high do not have
     * to be actual values in a. This method throws an
     * IllegalArgumentException if a is null or has zero length.
     * The array a is not changed by this method.
     */
    public static int[] range(int[] a, int low, int high) {
        if (a == null || a.length == 0){
            throw new IllegalArgumentException();
        }
        boolean[] inRange = new boolean[a.length]; //initializes as false
        for (int i = 0; i < a.length; i++){
            if (a[i] >= low && a[i] <= high){
                inRange[i] = true;
            }
        }

        int length = 0;
        for (boolean b: inRange){
            if (b){
                length++;
            }
        }
        
        if(length == 0){
            int[] empty = {};
            return empty;
        }

        int[] out = new int[length];
        int outIndex = 0;
        for (int i = 0; i < inRange.length; i++){
            if (inRange[i]){
                out[outIndex] = a[i];
                outIndex++;
            }
        }
        return out; 
       
    }


    /**
     * Returns the smallest value in a that is greater than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int ceiling(int[] a, int key) {
        if (a == null || a.length == 0){
            throw new IllegalArgumentException();
        }
        int[] sorted = a.clone();
        Arrays.sort(sorted);
        int i = 0;
        while (i < sorted.length && sorted[i] < key){ // not greater/equal to key
            i++;
        }
        if (i < sorted.length){
            return sorted[i];
        }
        else{
            throw new IllegalArgumentException();
        }
    }


    /**
     * Returns the largest value in a that is less than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int floor(int[] a, int key) {
        if (a == null || a.length == 0){
            throw new IllegalArgumentException();
        }
        int[] sorted = a.clone();
        Arrays.sort(sorted);
        int[] sorted_descending = reversedArray(sorted);
        int i = 0;
        while (i < sorted_descending.length && sorted_descending[i] > key){ // not greater/equal to key
            i++;
        }
        if (i < sorted_descending.length){
            return sorted_descending[i];
        }
        else{
            throw new IllegalArgumentException();
        }
    }


    private static int[] reversedArray(int[] a){
        int[] out = new int[a.length];
        int j = 0;
        for (int i = (a.length - 1); i >= 0; i--, j++){ //reverse array
            out[j] = a[i];
        }
        return out;
    }

}
