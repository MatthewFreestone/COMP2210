import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SelectorSpecialTests {
   int[] someRepeat = {3,2,1,5,3,1,5,3};
   int[] repeat = {3,3,3,3,3,3,3};
   int[] minimax = {Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
   int[] one = {1};
   int[] two = {1,2};
   

   @Test
   public void minTests(){
      assertEquals(1, Selector.min(someRepeat));
      assertEquals(3, Selector.min(repeat));
      assertEquals(Integer.MIN_VALUE, Selector.min(minimax));
      assertEquals(1, Selector.min(one));
      assertEquals(1, Selector.min(two));
   }

   @Test
   public void maxTests(){
      assertEquals(5, Selector.max(someRepeat));
      assertEquals(3, Selector.max(repeat));
      assertEquals(Integer.MAX_VALUE, Selector.max(minimax));
      assertEquals(1, Selector.max(one));
      assertEquals(2, Selector.max(two));
   }

   @Test
   public void kminTests(){
      assertEquals(5, Selector.kmin(someRepeat, 4));
      assertEquals(3, Selector.kmin(repeat, 1));
      assertEquals(0, Selector.kmin(minimax, 2));
      assertEquals(1, Selector.kmin(one,1));
      assertEquals(2, Selector.kmin(two,2));
   }

   @Test
   public void kmaxTests(){
      assertEquals(1, Selector.kmax(someRepeat, 4));
      assertEquals(3, Selector.kmax(repeat, 1));
      assertEquals(0, Selector.kmax(minimax, 2));
      assertEquals(1, Selector.kmax(one,1));
      assertEquals(1, Selector.kmax(two,2));
   }

   @Test
   public void rangeTests(){
      assertArrayEquals(new int[0], Selector.range(repeat, 15, 30));
      int[] ans = {1};
      assertArrayEquals(ans, Selector.range(one, -1, 15));
   }
   
}
