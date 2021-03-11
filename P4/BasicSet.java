import java.util.HashSet;
import java.util.Iterator;
/**
 * Class used for testing basics on Set interface, not for actual use
 */
public class BasicSet<T> implements Set<T>{
    HashSet<T> set; 

    public BasicSet(){
        set = new HashSet<T>();
    }
    @Override
    public boolean add(T element) {
        return set.add(element);
    }
    @Override
    public boolean remove(T element) {
        return set.remove(element);
    }
    @Override
    public boolean contains(T element) {
        return set.contains(element);
    }
    @Override
    public Set<T> union(Set<T> s) {
        return null;
    }
    @Override
    public Set<T> intersection(Set<T> s) {
        return null;
    }
    @Override
    public Set<T> complement(Set<T> s) {
        return null;
    }
    @Override
    public boolean equals(Set<T> s) {
        if (s.getClass() == this.getClass()){
            BasicSet<T> sh = (BasicSet<T>)s;
            return (this.set.equals(sh.set));
        }
        return s.equals(this); //bad practice, but less work 
    }
    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
    @Override
    public boolean isEmpty() {
        return (set.size() == 0);
    }
    @Override
    public int size() {
        return set.size();
    }

    @Override
    public String toString() {
        return set.toString();
    }


}
