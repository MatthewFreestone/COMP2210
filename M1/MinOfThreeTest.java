import org.junit.Assert;

import org.junit.Test;

public class MinOfThreeTest {
   @Test
   public void dupTest1(){
      int act = MinOfThree.min1(1,2,1);
      int expected = 1;
      Assert.assertEquals(expected,act);
   }
   @Test
   public void dupTest2(){
      int act = MinOfThree.min1(2,1,1);
      int expected = 1;
      Assert.assertEquals(expected,act);
   }
   @Test
   public void dupTest3(){
      int act = MinOfThree.min1(2,2,3);
      int expected = 2;
      Assert.assertEquals(expected,act);
   }
   @Test
   public void dupTest7(){
      int act = MinOfThree.min1(2,2,2);
      int expected = 2;
      Assert.assertEquals(expected,act);
   }



   @Test
   public void dupTest4(){
      int act = MinOfThree.min2(1,2,1);
      int expected = 1;
      Assert.assertEquals(expected,act);
   }
   @Test
   public void dupTest5(){
      int act = MinOfThree.min2(2,1,1);
      int expected = 1;
      Assert.assertEquals(expected,act);
   }
   @Test
   public void dupTest6(){
      int act = MinOfThree.min2(2,2,3);
      int expected = 2;
      Assert.assertEquals(expected,act);
   }
   @Test
   public void dupTest8(){
      int act = MinOfThree.min2(2,2,2);
      int expected = 2;
      Assert.assertEquals(expected,act);
   }


   @Test
   public void basic1(){
      int act = MinOfThree.min1(3,2,1);
      int expected = 1;
      Assert.assertEquals(expected,act);
   }
   @Test
   public void basic2(){
      int act = MinOfThree.min1(3,1,2);
      int expected = 1;
      Assert.assertEquals(expected,act);
   }
   @Test
   public void basic3(){
      int act = MinOfThree.min1(1,2,3);
      int expected = 1;
      Assert.assertEquals(expected,act);
   }


   @Test
   public void basic4(){
      int act = MinOfThree.min2(3,2,1);
      int expected = 1;
      Assert.assertEquals(expected,act);
   }
   @Test
   public void basic5(){
      int act = MinOfThree.min2(3,1,2);
      int expected = 1;
      Assert.assertEquals(expected,act);
   }
   @Test
   public void basic6(){
      int act = MinOfThree.min2(1,2,3);
      int expected = 1;
      Assert.assertEquals(expected,act);
   }
}
