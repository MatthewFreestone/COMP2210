import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.*;

public class SelectorTest {

   static Comparator<Integer> ascendingInteger =
        new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i1.compareTo(i2);
            }
        };

   List<Integer> a = Arrays.asList(new Integer[]{10,4,5,6,71,2});


   @Test
   public void minTest() {
      Integer i = 2;
      assertTrue(i == Selector.<Integer>min(a,  ascendingInteger));
   }
   @Test
   public void maxTest() {
      Integer i = 71;
      assertTrue(i == Selector.<Integer>max(a,  ascendingInteger));
   }

}

