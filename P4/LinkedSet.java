import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;

class LinkedSet<T extends Comparable<T>> implements Set<T>{
    Node first = null;
    Node last; 

    private class Node<T>{
        Node next;
        Node prev; 
        T e; 

        Node(T e) {
            this.e = e;
        }
        Node(T e, Node next, Node prev) {
            this.e = e;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public boolean add(T e) {
        if (first == null){
            first = new Node(e);
            return true;
        }

        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean remove(Object e) {
        // TODO Auto-generated method stub
        return false;
    }
    /**
     * Returns {@code true} if this set contains the specified element.
     * More formally, returns {@code true} if and only if this set
     * contains an element {@code e} such that
     * {@code Objects.equals(o, e)}.
     *
     * @param o element whose presence in this set is to be tested
     * @return {@code true} if this set contains the specified element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this set
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *         set does not permit null elements
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    @Override
    public boolean contains(Object o) {
        Class type = ((T) new Object()).getClass(); //ow
        if (!type.isInstance(o)){
            throw new ClassCastException();
        }
        return false;
    }
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

}