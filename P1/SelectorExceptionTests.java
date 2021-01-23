import org.junit.Test;

public class SelectorExceptionTests {

   int[] nArray = null;
   int[] eArray = {};
   int[] valid = {1,2,2,4,5};

   @Test(expected = IllegalArgumentException.class)
   public void minNull(){
      Selector.min(nArray);
   }
   @Test(expected = IllegalArgumentException.class)
   public void minEmpty(){
      Selector.min(eArray);
   }

   @Test(expected = IllegalArgumentException.class)
   public void maxNull(){
      Selector.max(nArray);
   }
   @Test(expected = IllegalArgumentException.class)
   public void maxEmpty(){
      Selector.max(eArray);
   }

   @Test(expected = IllegalArgumentException.class)
   public void kminNull(){
      Selector.kmin(nArray, 5);
   }
   @Test(expected = IllegalArgumentException.class)
   public void kminEmpty(){
      Selector.kmin(eArray, 5);
   }
   @Test(expected = IllegalArgumentException.class)
   public void kminKLow(){
      Selector.kmin(valid, 0);
   }
   @Test(expected = IllegalArgumentException.class)
   public void kminKHigh(){
      Selector.kmin(valid, 500);
   }
   @Test(expected = IllegalArgumentException.class)
   public void kminMoreThanUnique(){
      Selector.kmin(valid, 5);
   }



   @Test(expected = IllegalArgumentException.class)
   public void kmaxNull(){
      Selector.kmax(nArray, 5);
   }
   @Test(expected = IllegalArgumentException.class)
   public void kmaxEmpty(){
      Selector.kmax(eArray, 5);
   }
   @Test(expected = IllegalArgumentException.class)
   public void kmaxKLow(){
      Selector.kmax(valid, 0);
   }
   @Test(expected = IllegalArgumentException.class)
   public void kmaxKHigh(){
      Selector.kmax(valid, 500);
   }
   @Test(expected = IllegalArgumentException.class)
   public void kmaxMoreThanUnique(){
      Selector.kmax(valid, 5);
   }


   @Test(expected = IllegalArgumentException.class)
   public void rangeNull(){
      Selector.range(nArray,1,5);
   }
   @Test(expected = IllegalArgumentException.class)
   public void rangeEmpty(){
      Selector.range(eArray,1,5);
   }


   @Test(expected = IllegalArgumentException.class)
   public void ceilingNull(){
      Selector.ceiling(nArray,1);
   }
   @Test(expected = IllegalArgumentException.class)
   public void ceilingEmpty(){
      Selector.ceiling(eArray,1);
   }
   @Test(expected = IllegalArgumentException.class)
   public void ceilingHighKey(){
      Selector.ceiling(valid, 300);
   }

   @Test(expected = IllegalArgumentException.class)
   public void floorNull(){
      Selector.floor(nArray,1);
   }
   @Test(expected = IllegalArgumentException.class)
   public void floorEmpty(){
      Selector.floor(eArray,1);
   }
   @Test(expected = IllegalArgumentException.class)
   public void floorLowKey(){
      Selector.floor(valid, -1);
   }











}