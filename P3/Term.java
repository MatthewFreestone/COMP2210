import java.util.Comparator;

public class Term implements Comparable<Term> {

   String query;
   long weight;

   /**
    * Initialize a term with the given query and weight.
    * This method throws a NullPointerException if query is null,
    * and an IllegalArgumentException if weight is negative.
    */
   public Term(String query, long weight) { 
      if (query == null){
         throw new NullPointerException();
      }
      if (weight < 0){
         throw new IllegalArgumentException();
      }
      this.query = query;
      this.weight = weight;
   }

   /**
    * Compares the two terms in descending order of weight.
    */
   public static Comparator<Term> byDescendingWeightOrder() { 
      return 
         new Comparator<Term>(){
            @Override
            public int compare(Term o1, Term o2) {
               Long l1 = o1.weight;
               Long l2 = o2.weight;
               return l2.compareTo(l1);
               // long diff = o2.weight - o1.weight; 
               // return (int)diff;
            }
         };
   
   }


   /**
    * Compares the two terms in ascending lexicographic order of query,
    * but using only the first length characters of query. This method
    * throws an IllegalArgumentException if length is less than or equal
    * to zero.
    */
   public static Comparator<Term> byPrefixOrder(int length) { 
      if (length <= 0){
         throw new IllegalArgumentException();
      }
      return 
         new Comparator<Term>(){
            @Override
            public int compare(Term o1, Term o2) {
               String s1 = SafeSubstring(o1.query, length);
               String s2 = SafeSubstring(o2.query, length);
               // String s1 = o1.query.substring(0, length);
               // String s2 = o2.query.substring(0, length);
               return s1.compareTo(s2);
            }
         };
   }
   private static String SafeSubstring(String in, int end){
      if (in.length() > end){
         return in.substring(0, end);
      }
      else{
         return in; 
      }
   }

   /**
    * Compares this term with the other term in ascending lexicographic order
    * of query.
    */
   @Override
   public int compareTo(Term other) { 
      return this.query.compareTo(other.query);
   }

   /**
    * Returns a string representation of this term in the following format:
    * query followed by a tab followed by weight
    */
   @Override
   public String toString(){
      return String.format(query + "\t" + weight);
   }

}