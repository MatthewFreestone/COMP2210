/**
 * Applies the linear scan strategy to counting the number of negative
 * values in an array.
 */
public class CountNegatives {

    /**
     * Returns the number of negative values in the given array.
     */
    public static int countNegatives(int[]a) {
        int neg = 0;
        for (int x: a){
            if(x < 0){
                neg++;
            }
        }
        return neg; 
    }
}
