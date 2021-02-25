import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AutocompleteTest {
   @Test
   public void allMatchesTest(){

      Term[] terms = {
               new Term("the",23135851162L), 
               new Term("of",13151942776L),
               new Term("and",12997637966L),
               new Term("to",12136980858L),
               new Term("a",9081174698L),
               new Term("in",8469404971L),
               new Term("for",5933321709L),
               new Term("is",4705743816L),
               new Term("on",3750423199L),
               new Term("that",3400031103L)};
      Autocomplete a = new Autocomplete(terms);
      Term[] out = a.allMatches("a");
      if (out != null){
         for (Term t: out){
            System.out.println(t);
         }
      }
   }

}

