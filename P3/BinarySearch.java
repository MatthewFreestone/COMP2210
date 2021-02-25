import java.util.Comparator; 

public class BinarySearch {

   /**
    * Returns the index of the first key in a[] that equals the search key, 
    * or -1 if no such key exists. This method throws a NullPointerException
    * if any parameter is null.
    */
   public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) { 
      if (a == null || key == null || comparator == null){
         throw new NullPointerException();
      }
      int left = 0;
      int right = a.length-1;
      int middle = -1;
      while (left <= right){
         middle = (right+left)/ 2;
         if (comparator.compare(a[middle], key) == 0){
            break;
         }
         else if (comparator.compare(a[middle], key) > 0){
            right = middle - 1;
         }
         else {
            left = middle + 1;
         }
      }
      if (comparator.compare(a[middle], key) != 0) 
         return -1;
      right = middle;
      while (left <= right){
         middle = (right+left)/ 2;
         if (comparator.compare(a[middle], key) == 0){
            right = middle-1;
         }
         else {
            left = middle + 1;
         }
      }
      return (comparator.compare(a[middle], key) == 0) ? middle : middle+1; 
   }

   /**
    * Returns the index of the last key in a[] that equals the search key, 
    * or -1 if no such key exists. This method throws a NullPointerException
    * if any parameter is null.
    */
   public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      if (a == null || key == null || comparator == null){
         throw new NullPointerException();
      }
      int left = 0;
      int right = a.length-1;
      int middle = -1;
      while (left <= right){
         middle = (right+left)/ 2;
         if (comparator.compare(a[middle], key) == 0){
            break;
         }
         else if (comparator.compare(a[middle], key) > 0){
            right = middle - 1;
         }
         else {
            left = middle + 1;
         }
      }
      if (comparator.compare(a[middle], key) != 0) 
         return -1;
      left = middle;
      while (left <= right){
         middle = (right+left)/ 2;
         if (comparator.compare(a[middle], key) == 0){
            left = middle + 1;
         }
         else {
            right = middle-1;
         }
      }
      return (comparator.compare(a[middle], key) == 0) ? middle : middle-1; 
   }
}
