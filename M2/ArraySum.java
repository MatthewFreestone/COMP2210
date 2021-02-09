/**
 * Provides a sum function on arrays.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-03-26
 */
public class ArraySum {

	/** Returns the sum of values in the given array. */
	public static int sum(int[] a, int left, int right) {
		int t = 0;
		for (int i = left;i <= right;i++ ) {
			t+=a[i];
		}
		return t; 
	}

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		System.out.println(sum(a, 0, 3));
	}
}
