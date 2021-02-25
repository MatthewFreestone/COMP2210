import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Comparator;

public class BinarySearchTest {
   Integer[] a = {0,3,4,5,7,8,8,8,8,8,9,10,11,12,15,16,18,20};
   Integer[] b = {8,8,8,8,8,8,8,8,8,8,8,8,8,8,8};
   Integer[] c = {8,8,8,8,8,8,8,8,8,8,8,9,10,11,12,13,14};
   Integer[] d = {0,1,2,3,4,5,6,7,8,8,8,8,8};
   @Test
   public void firstIndexTest(){
      assertEquals(5, BinarySearch.firstIndexOf(a, 8, new AscendingComparator()));
      assertEquals(0, BinarySearch.firstIndexOf(b, 8, new AscendingComparator()));
      assertEquals(0, BinarySearch.firstIndexOf(c, 8, new AscendingComparator()));
      assertEquals(8, BinarySearch.firstIndexOf(d, 8, new AscendingComparator()));
   }
   @Test
   public void lastIndexTest(){
      assertEquals(9, BinarySearch.lastIndexOf(a, 8, new AscendingComparator()));
      assertEquals(14, BinarySearch.lastIndexOf(b, 8, new AscendingComparator()));
      assertEquals(10, BinarySearch.lastIndexOf(c, 8, new AscendingComparator()));
      assertEquals(12, BinarySearch.lastIndexOf(d, 8, new AscendingComparator()));
   }
}

