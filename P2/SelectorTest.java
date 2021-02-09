import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.*;

public class SelectorTest {

   static Comparator<Integer> comp =
        new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i1.compareTo(i2);
            }
        };

   Integer[] a_array = new Integer[]{8, 2, 8, 7, 3, 3, 4};
   Collection<Integer> a = Arrays.asList(a_array);

   Integer min = 2;
   Integer max = 8;

   int k = 5;
   Integer kmin = 2; 
   Integer kmax = 8;

   int low = 3;
   int high = 7;
   Collection<Integer> range = Arrays.asList(new Integer[]{7,3,3,4});

   int floor_key = 5;
   Integer floor = 4;
   
   int ceiling_key  = 5;
   Integer ceiling = 7;


   @Test
   public void minTest() {
      assertEquals(min, Selector.<Integer>min(a,  comp));
   }
   @Test
   public void maxTest() {
      assertEquals(max, Selector.<Integer>max(a,  comp));
   }

   @Test
   public void kminTest(){
      assertEquals(kmin, Selector.<Integer>kmin(a, k, comp));
   }

   @Test
   public void kmaxTest(){
      assertEquals(kmax, Selector.<Integer>kmax(a, k, comp));
   }

   @Test
   public void rangeTest(){
      Collection<Integer> ans = Selector.<Integer>range(a, low, high, comp);
      assertTrue("Expected: " + range.toString() + "; Actual: " + ans,range.equals(ans));
   }

   @Test
   public void floorTest(){
      assertEquals(floor, Selector.<Integer>floor(a, floor_key, comp));
   }

   @Test
   public void ceilingTest(){
      assertEquals(ceiling, Selector.<Integer>ceiling(a, ceiling_key, comp));
   }

}

