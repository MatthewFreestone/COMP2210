import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException; 

/**
 * Defines a library of selection methods on Collections.
 *
 * @author  Matthew Freestone (maf0083@auburn.edu)
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
     * Returns the minimum value in the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty, this method throws a
     * NoSuchElementException. This method will not change coll in any way.
     *
     * @param coll    the Collection from which the minimum is selected
     * @param comp    the Comparator that defines the total order on T
     * @return        the minimum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T min(Collection<T> coll, Comparator<T> comp) {
        if (coll == null || comp == null){
            throw new IllegalArgumentException();
        }
        if (coll.size() == 0){
            throw new NoSuchElementException();
        }
        Iterator<T> i = coll.iterator();
        T min = i.next();
        while(i.hasNext()){
            T curr = i.next();
            if (comp.compare(min, curr) > 0){
                min = curr;
            }
        }
        return min; 
    }


    /**
     * Selects the maximum value in the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty, this method throws a
     * NoSuchElementException. This method will not change coll in any way.
     *
     * @param coll    the Collection from which the maximum is selected
     * @param comp    the Comparator that defines the total order on T
     * @return        the maximum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T max(Collection<T> coll, Comparator<T> comp) {
        if (coll == null || comp == null){
            throw new IllegalArgumentException();
        }
        if (coll.size() == 0){
            throw new NoSuchElementException();
        }
        Iterator<T> i = coll.iterator();
        T max = i.next();
        while(i.hasNext()){
            T curr = i.next();
            if (comp.compare(max, curr) < 0){
                max = curr;
            }
        }
        return max; 
    }


    /**
     * Selects the kth minimum value from the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty or if there is no kth minimum
     * value, this method throws a NoSuchElementException. This method will not
     * change coll in any way.
     *
     * @param coll    the Collection from which the kth minimum is selected
     * @param k       the k-selection value
     * @param comp    the Comparator that defines the total order on T
     * @return        the kth minimum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) { //O(n^2)
        if (coll == null || comp == null){
            throw new IllegalArgumentException();
        }
        if (coll.size() == 0){
            throw new NoSuchElementException();
        }

        List<T> uniqueVals = new ArrayList<T>();
        for (T c: coll){
            if (!uniqueVals.contains(c)){
                uniqueVals.add(c);
            }
        }
        if (k > uniqueVals.size() || k < 1){
            throw new NoSuchElementException();
        }

        java.util.Collections.sort(uniqueVals, comp);
        return uniqueVals.get(k-1);
    }

   


    /**
     * Selects the kth maximum value from the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty or if there is no kth maximum
     * value, this method throws a NoSuchElementException. This method will not
     * change coll in any way.
     *
     * @param coll    the Collection from which the kth maximum is selected
     * @param k       the k-selection value
     * @param comp    the Comparator that defines the total order on T
     * @return        the kth maximum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) { 
        if (coll == null || comp == null){
            throw new IllegalArgumentException();
        }
        if (coll.size() == 0){
            throw new NoSuchElementException();
        }

        List<T> uniqueVals = new ArrayList<T>();
        for (T c: coll){
            if (!uniqueVals.contains(c)){
                uniqueVals.add(c);
            }
        }
        if (k > uniqueVals.size() || k < 1){
            throw new NoSuchElementException();
        }

        java.util.Collections.sort(uniqueVals, comp.reversed());
        return uniqueVals.get(k-1);
    }

    /**
     * Returns a new Collection containing all the values in the Collection coll
     * that are greater than or equal to low and less than or equal to high, as
     * defined by the Comparator comp. The returned collection must contain only
     * these values and no others. The values low and high themselves do not have
     * to be in coll. Any duplicate values that are in coll must also be in the
     * returned Collection. If no values in coll fall into the specified range or
     * if coll is empty, this method throws a NoSuchElementException. If either
     * coll or comp is null, this method throws an IllegalArgumentException. This
     * method will not change coll in any way.
     *
     * @param coll    the Collection from which the range values are selected
     * @param low     the lower bound of the range
     * @param high    the upper bound of the range
     * @param comp    the Comparator that defines the total order on T
     * @return        a Collection of values between low and high
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> Collection<T> range(Collection<T> coll, T low, T high, Comparator<T> comp) {
        if (coll == null || comp == null){
            throw new IllegalArgumentException();
        }
        if (coll.size() == 0){
            throw new NoSuchElementException();
        }

        Collection<T> out = new ArrayList<T>();
        for(T val: coll){
            if (comp.compare(val, low) >= 0 &&  comp.compare(val, high) <= 0){
                out.add(val);
            } 
        }
        if (out.size() == 0){
            throw new NoSuchElementException();
        }
        return out; 

    }


    /**
     * Returns the smallest value in the Collection coll that is greater than
     * or equal to key, as defined by the Comparator comp. The value of key
     * does not have to be in coll. If coll or comp is null, this method throws
     * an IllegalArgumentException. If coll is empty or if there is no
     * qualifying value, this method throws a NoSuchElementException. This
     * method will not change coll in any way.
     *
     * @param coll    the Collection from which the ceiling value is selected
     * @param key     the reference value
     * @param comp    the Comparator that defines the total order on T
     * @return        the ceiling value of key in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {
        if (coll == null || comp == null){
            throw new IllegalArgumentException();
        }
        if (coll.size() == 0){
            throw new NoSuchElementException();
        }

        T min = null;
        Iterator<T> i = coll.iterator();
        while(i.hasNext()){ //go till first val above key found  
            T curr = i.next();
            if(comp.compare(curr, key) >= 0){
                min = curr;
                break;
            }
        }

        if (min == null){ //could also do !i.hasNext()
            throw new NoSuchElementException();
        }

        while(i.hasNext()){ //go thrugh rest to see if any are lower than first min
            T curr = i.next();
            if(comp.compare(curr, key) >= 0 && comp.compare(curr, min) < 0){
                min = curr;
            }
        } 
        return min;
    }


    /**
     * Returns the largest value in the Collection coll that is less than
     * or equal to key, as defined by the Comparator comp. The value of key
     * does not have to be in coll. If coll or comp is null, this method throws
     * an IllegalArgumentException. If coll is empty or if there is no
     * qualifying value, this method throws a NoSuchElementException. This
     * method will not change coll in any way.
     *
     * @param coll    the Collection from which the floor value is selected
     * @param key     the reference value
     * @param comp    the Comparator that defines the total order on T
     * @return        the floor value of key in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
        if (coll == null || comp == null){
            throw new IllegalArgumentException();
        }
        if (coll.size() == 0){
            throw new NoSuchElementException();
        }

        T max = null;
        Iterator<T> i = coll.iterator();
        while(i.hasNext()){ //go till first val below key found  
            T curr = i.next();
            if(comp.compare(curr, key) <= 0){
                max = curr;
                break;
            }
        }

        if (max == null){ //could also do !i.hasNext()
            throw new NoSuchElementException();
        }

        while(i.hasNext()){ //go thrugh rest to see if any are higher than first max
            T curr = i.next();
            if(comp.compare(curr, key) <= 0 && comp.compare(curr, max) > 0){
                max = curr;
            }
        } 
        return max;
    }

}
