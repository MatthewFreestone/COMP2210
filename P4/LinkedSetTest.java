import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class LinkedSetTest {
    Integer[] a = {1,2,3,4,5};
   @Test
   public void addTest(){
       LinkedSet<Integer> s = new LinkedSet<Integer>();
       assertEquals("One, first time", true, s.add(1));
       assertEquals("Three", true, s.add(3));
       assertEquals("Two", true, s.add(2));
       assertEquals("One, second time", false, s.add(1));
       System.out.println(s.toString());
   }
   @Test
   public void removeTest(){
        LinkedSet<Integer> s = new LinkedSet<Integer>();
        s.add(1);s.add(2);s.add(3);
        assertEquals(true, s.remove(1));
        assertEquals(false, s.remove(1));
        assertEquals(true, s.remove(2));
        assertEquals(true, s.remove(3));
        assertEquals(false, s.remove(-1));
        System.out.println(s.toString());
   }
   @Test
   public void containsTest(){
        LinkedSet<Integer> s = new LinkedSet<Integer>();
        s.add(1);s.add(2);s.add(3);
        assertEquals(true, s.contains(2));
        assertEquals(true, s.contains(3));
        assertEquals(true, s.contains(1));
        assertEquals(false, s.contains(0));
   }

   @Test
   public void toStringTest(){
        LinkedSet<Integer> s = new LinkedSet<Integer>();
        s.add(1);s.add(3);s.add(2);s.add(5);
        s.add(0);s.add(-5);s.add(Integer.MAX_VALUE);s.add(Integer.MIN_VALUE);
        System.out.println(s.toString());
   }
   
   @Test
   public void equalsLinkedTest(){
        LinkedSet<Integer> x = new LinkedSet<Integer>();
        x.add(1);x.add(2);x.add(3);
        LinkedSet<Integer> y = new LinkedSet<Integer>();
        y.add(1);y.add(2);y.add(3);
        LinkedSet<Integer> z = new LinkedSet<Integer>();
        z.add(1);z.add(2);z.add(4);

        assertEquals(true, x.equals(y));
        assertEquals(false, x.equals(z));
   }

   @Test
   public void equalsTest(){
        BasicSet<Integer> x = new BasicSet<>();
        x.add(1);x.add(2);x.add(3);
        LinkedSet<Integer> y = new LinkedSet<>();
        y.add(1);y.add(2);y.add(3);
        BasicSet<Integer> z = new BasicSet<>();
        z.add(1);z.add(2);

        assertEquals(true, y.equals(x));
        assertEquals(false, y.equals(z));
   }

   

   @Test
   public void unionTest(){
        LinkedSet<Integer> unionSoln =  new LinkedSet<>();
        unionSoln.add(1); 
        unionSoln.add(2); 
        unionSoln.add(3); 
        unionSoln.add(4); 
        unionSoln.add(5); 

        BasicSet<Integer> x = new BasicSet<>();
        x.add(1);x.add(4);x.add(3);
        LinkedSet<Integer> y = new LinkedSet<Integer>();
        y.add(5);y.add(2);y.add(3);

        Set<Integer> unioned = y.union(x);
        System.out.println(unioned.toString());
        assertEquals(true, unionSoln.equals(unioned));
   }

   @Test
   public void unionLinkedTest(){
        LinkedSet<Integer> unionSoln =  new LinkedSet<>();
        unionSoln.add(1); 
        unionSoln.add(2); 
        unionSoln.add(3); 
        unionSoln.add(4); 
        unionSoln.add(5); 
        //TODO test with empty list 
        LinkedSet<Integer> x = new LinkedSet<>();
        x.add(1);x.add(4);x.add(3);
        LinkedSet<Integer> y = new LinkedSet<>();
        y.add(5);y.add(2);y.add(3);

        System.out.println(x.toString());
        System.out.println(y.toString());

        Set<Integer> unioned = y.union(x);
        System.out.println(unioned.toString());
        assertEquals(true, unionSoln.equals(unioned));
   }



}
