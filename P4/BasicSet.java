import java.util.HashSet;
import java.util.Iterator;
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
        //TODO Auto-generated method stub
        return null;
    }
    @Override
    public Set<T> intersection(Set<T> s) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Set<T> complement(Set<T> s) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public boolean equals(Set<T> s) {
        return set.equals(s);
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
