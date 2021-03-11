import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Iterator;
public class LinkedSetTest {
     LinkedSet<Integer> e1 = new LinkedSet<>();
     LinkedSet<Integer> e2 = new LinkedSet<>();
     BasicSet<Integer> be = new BasicSet<>();
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
        assertEquals(false, e1.remove(0));
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
        assertEquals(false, e1.contains(0));
   }

   @Test
   public void toStringTest(){
        LinkedSet<Integer> s = new LinkedSet<Integer>();
        s.add(1);s.add(3);s.add(2);s.add(5);
        s.add(0);s.add(-5);s.add(Integer.MAX_VALUE);s.add(Integer.MIN_VALUE);
        System.out.println(s.toString());
        System.out.println(e1.toString());
   }
   
   @Test
   public void equalsLinkedTest(){
        LinkedSet<Integer> x = new LinkedSet<Integer>();
        x.add(1);x.add(2);x.add(3);
        LinkedSet<Integer> y = new LinkedSet<Integer>();
        y.add(1);y.add(2);y.add(3);
        LinkedSet<Integer> z = new LinkedSet<Integer>();
        z.add(1);z.add(2);z.add(4);

        assertEquals(false, x.equals(e1));
        assertEquals(true, e1.equals(e2));
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

        assertEquals(true, e1.equals(be));
        assertEquals(false, x.equals(e1));
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
        assertEquals(true, unionSoln.equals(unionSoln.union(be)));
        assertEquals(true, e1.equals(e1.union(be)));
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
        assertEquals(true, unionSoln.equals(unionSoln.union(e1)));
        assertEquals(true, e1.equals(e1.union(e2)));
   }

   @Test
   public void unionLinkedProblem(){
     LinkedSet<Integer> unionSoln =  new LinkedSet<>();
     unionSoln.add(1); 
     unionSoln.add(2); 
     unionSoln.add(3); 

     LinkedSet<Integer> x = new LinkedSet<>();
     x.add(1);x.add(2);x.add(3);
     LinkedSet<Integer> y = new LinkedSet<>();
     y.add(1);y.add(2);y.add(3);

     System.out.println(x.toString());
     System.out.println(y.toString());

     Set<Integer> unioned = y.union(x);
     System.out.println(unioned.toString());
     assertEquals(true, unionSoln.equals(unioned));

   }

   @Test
   public void complimentTest(){
     LinkedSet<Integer> complSoln =  new LinkedSet<>();
     complSoln.add(1); 
     // complSoln.add(2); 
     complSoln.add(3); 
     // complSoln.add(4); 
     complSoln.add(5); 

     LinkedSet<Integer> x = new LinkedSet<Integer>();
     x.add(1);x.add(2);x.add(3);x.add(4);x.add(5);
     BasicSet<Integer> y = new BasicSet<>();
     y.add(2);y.add(4);
     Set<Integer> comp = x.complement(y);
     assertEquals(true, complSoln.equals(comp));
     assertEquals(true, complSoln.equals(complSoln.complement(be)));
     assertEquals(true, e1.equals(e1.complement(be)));
   }
   @Test
   public void complimentLinkedTest(){
     LinkedSet<Integer> complSoln =  new LinkedSet<>();
     complSoln.add(1); 
     // complSoln.add(2); 
     complSoln.add(3); 
     // complSoln.add(4); 
     complSoln.add(5); 

     LinkedSet<Integer> x = new LinkedSet<>();
     x.add(1);x.add(2);x.add(3);x.add(4);x.add(5);
     LinkedSet<Integer> y = new LinkedSet<>();
     y.add(2);y.add(4);
     Set<Integer> comp = x.complement(y);
     assertEquals(true, complSoln.equals(comp));
     assertEquals(true, complSoln.equals(complSoln.complement(e1)));
     assertEquals(true, e1.equals(e1.complement(e2)));
   }

   @Test
   public void intersectionTest(){
     LinkedSet<Integer> interSoln =  new LinkedSet<>();
     // interSoln.add(1); 
     interSoln.add(2); 
     // interSoln.add(3); 
     // interSoln.add(4); 
     // interSoln.add(5); 

     LinkedSet<Integer> x = new LinkedSet<Integer>();
     x.add(1);x.add(2);x.add(3);x.add(5);
     BasicSet<Integer> y = new BasicSet<>();
     y.add(2);y.add(4);
     Set<Integer> intr = x.intersection(y);
     assertEquals(true, interSoln.equals(intr));
     assertEquals(true, e1.equals(interSoln.intersection(be)));
   }

   @Test
   public void intersectionLinkedTest(){
     LinkedSet<Integer> interSoln =  new LinkedSet<>();
     // interSoln.add(1); 
     interSoln.add(2); 
     // interSoln.add(3); 
     // interSoln.add(4); 
     // interSoln.add(5); 

     LinkedSet<Integer> x = new LinkedSet<Integer>();
     x.add(1);x.add(2);x.add(3);x.add(5);
     LinkedSet<Integer> y = new LinkedSet<>();
     y.add(2);y.add(4);
     Set<Integer> intr = x.intersection(y);
     System.out.println(intr);
     assertEquals(true, interSoln.equals(intr));
     assertEquals(true, e1.equals(interSoln.intersection(e2)));
     assertEquals(true, e1.equals(e1.intersection(interSoln)));
     assertEquals(true, e1.equals(e1.intersection(e2)));
   }

   @Test
   public void incIteratorTest(){
        LinkedSet<Integer> x = new LinkedSet<>();
        x.add(1);x.add(4);x.add(3);
        Iterator<Integer> i = x.iterator();
        while(i.hasNext()){
             System.out.println(i.next());
        }
   }
   @Test
   public void incIteratorTest_E(){
        LinkedSet<Integer> x = new LinkedSet<>();
        Iterator<Integer> i = x.iterator();
        while(i.hasNext()){
             System.out.println(i.next());
        }
   }

   @Test
   public void decIteratorTest(){
        LinkedSet<Integer> x = new LinkedSet<>();
        x.add(1);x.add(4);x.add(3);
        Iterator<Integer> i = x.descendingIterator();
        while(i.hasNext()){
             System.out.println(i.next());
        }
   }
   @Test
   public void decIteratorTest_E(){
        LinkedSet<Integer> x = new LinkedSet<>();
        Iterator<Integer> i = x.descendingIterator();
        while(i.hasNext()){
             System.out.println(i.next());
        }
   }

   @Test
   public void powSetIteratorTest(){
        LinkedSet<Integer> x = new LinkedSet<>();
        x.add(1);x.add(4);x.add(3);
        Iterator<Set<Integer>> i = x.powerSetIterator();
        while(i.hasNext()){
             Set<Integer> c = i.next();
             System.out.print("{");
             for(int e: c){
                  System.out.print(e + ", ");
             }
             System.out.println("}");
        }
   }

   @Test
   public void powSetIteratorTest_E(){
        LinkedSet<Integer> x = new LinkedSet<>();
        Iterator<Set<Integer>> i = x.powerSetIterator();
        while(i.hasNext()){
             Set<Integer> c = i.next();
             System.out.print("{");
             for(int e: c){
                  System.out.print(e + ", ");
             }
             System.out.println("}");
        }
   }

}
