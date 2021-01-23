import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class SelectorTests {

   int[] a = {2, 8, 7, 3, 4};
   int[] b = {5, 9, 1, 7, 3};
   int[] c = {8, 7, 6, 5, 4};
   int[] d = {8, 2, 8, 7, 3, 3, 4};


   @Test
   public void minTest(){
      assertEquals(2, Selector.min(a));
      assertEquals(1, Selector.min(b));
      assertEquals(4, Selector.min(c));
      assertEquals(2, Selector.min(d));
   }

   @Test
   public void maxTest(){
      assertEquals(8, Selector.max(a));
      assertEquals(9, Selector.max(b));
      assertEquals(8, Selector.max(c));
      assertEquals(8, Selector.max(d));
   }

   @Test
   public void kminTest_1(){
      assertEquals(2, Selector.kmin(a,1));
   }
   @Test
   public void kminTest_2(){
      assertEquals(5, Selector.kmin(b,3));
   }
   @Test
   public void kminTest_3(){
      assertEquals(8, Selector.kmin(c,5));
   }
   @Test
   public void kminTest_4(){
      assertEquals(4, Selector.kmin(d,3));
   }
   
      
      

   @Test
   public void kmaxTest_1(){
      assertEquals(8, Selector.kmax(a,1));
   }
   @Test
   public void kmaxTest_2(){
      assertEquals(5, Selector.kmax(b,3));
   }
   @Test
   public void kmaxTest_3(){
      assertEquals(4, Selector.kmax(c,5));
   }
   @Test
   public void kmaxTest_4(){
      assertEquals(4, Selector.kmax(d,3));
   }
   
      
      

   @Test
   public void rangeTest_1(){
      int[] exp = {2,3,4};
      Arrays.sort(exp);
      int[] act = Selector.range(a,1,5);
      Arrays.sort(act);
      assertArrayEquals(exp, act);
   }
   @Test
   public void rangeTest_2(){
      int[] exp = {5,3};
      Arrays.sort(exp);
      int[] act = Selector.range(b,3,5);
      Arrays.sort(act);
      assertArrayEquals(exp, act);
   }
   @Test
   public void rangeTest_3(){
      int[] exp = {8,7,6,5,4};
      Arrays.sort(exp);
      int[] act = Selector.range(c,4,8);
      Arrays.sort(act);
      assertArrayEquals(exp, act);
   }

   @Test
   public void rangeTest_4(){
      int[] exp = {7,3,3,4};
      Arrays.sort(exp);
      int[] act = Selector.range(d,3,7);
      Arrays.sort(act);
      assertArrayEquals(exp, act);
   }

   
   @Test
   public void floorTest_1(){
      assertEquals(4, Selector.floor(a,6));
   }
   @Test
   public void floorTest_2(){
      assertEquals(1, Selector.floor(b,1));
   }
   @Test
   public void floorTest_3(){
      assertEquals(8, Selector.floor(c,9));
   }
   @Test
   public void floorTest_4(){
      assertEquals(4, Selector.floor(d,5));
   }

   @Test
   public void ceilingTest_1(){
      assertEquals(2, Selector.ceiling(a,1));
   }
   @Test
   public void ceilingTest_2(){
      assertEquals(7, Selector.ceiling(b,7));
   }
   @Test
   public void ceilingTest_3(){
      assertEquals(4, Selector.ceiling(c,0));
   }
   @Test
   public void ceilingTest_4(){
      assertEquals(7, Selector.ceiling(d,5));
   }
  

   
   
}
