import java.util.Iterator;

import javax.swing.plaf.synth.SynthEditorPaneUI;

/**
 * Provides an implementation of the Set interface.
 * A doubly-linked list is used as the underlying data structure.
 * Although not required by the interface, this linked list is
 * maintained in ascending natural order. In those methods that
 * take a LinkedSet as a parameter, this order is used to increase
 * efficiency.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @author Matthew Freestone (you@auburn.edu)
 *
 */
public class LinkedSet<T extends Comparable<T>> implements Set<T> {

    //////////////////////////////////////////////////////////
    // Do not change the following three fields in any way. //
    //////////////////////////////////////////////////////////

    /** References to the first and last node of the list. */
    Node front;
    Node rear;

    /** The number of nodes in the list. */
    int size;

    /////////////////////////////////////////////////////////
    // Do not change the following constructor in any way. //
    /////////////////////////////////////////////////////////

    /**
     * Instantiates an empty LinkedSet.
     */
    public LinkedSet() {
        front = null;
        rear = null;
        size = 0;
    }


    //////////////////////////////////////////////////
    // Public interface and class-specific methods. //
    //////////////////////////////////////////////////

    ///////////////////////////////////////
    // DO NOT CHANGE THE TOSTRING METHOD //
    ///////////////////////////////////////
    /**
     * Return a string representation of this LinkedSet.
     *
     * @return a string representation of this LinkedSet
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (T element : this) {
            result.append(element + ", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }


    ///////////////////////////////////
    // DO NOT CHANGE THE SIZE METHOD //
    ///////////////////////////////////
    /**
     * Returns the current size of this collection.
     *
     * @return  the number of elements in this collection.
     */
    public int size() {
        return size;
    }

    //////////////////////////////////////
    // DO NOT CHANGE THE ISEMPTY METHOD //
    //////////////////////////////////////
    /**
     * Tests to see if this collection is empty.
     *
     * @return  true if this collection contains no elements, false otherwise.
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Ensures the collection contains the specified element. Neither duplicate
     * nor null values are allowed. This method ensures that the elements in the
     * linked list are maintained in ascending natural order.
     *
     * @param  element  The element whose presence is to be ensured.
     * @return true if collection is changed, false otherwise.
     */
    public boolean add(T element) {
        if (isEmpty()){
        	Node n = new Node(element);
        	front = n;
        	rear = n; 
            size++;
        	return true;
        }
        Node n = front;
        while (n.element.compareTo(element) < 0 && n.next != null){
            n = n.next;
        }

        if (n.element.compareTo(element) == 0){
            return false;
        }
        else if (n.element.compareTo(element) < 0){ //p belongs after n 
            Node p = new Node(element);
            if (n.next == null){//at end, p belongs at end
                rear = p;

                p.prev = n;
                n.next = p;
            }
            else{
                p.next = n.next;
                n.next.prev = p;
                p.prev = n;
                n.next = p;
            }
            size++;
            return true;
            
        }
        else { //p belongs before n 
            Node p = new Node(element);
            if (n == front){
                front = p;
                p.next = n;
                n.prev = p;
            }
            else{
                p.prev = n.prev;
                n.prev.next = p;
                p.next = n;
                n.prev = p; 
            }

            size++;
            return true;
        }

    }


    /**
     * Ensures the collection does not contain the specified element.
     * If the specified element is present, this method removes it
     * from the collection. This method, consistent with add, ensures
     * that the elements in the linked lists are maintained in ascending
     * natural order.
     *
     * @param   element  The element to be removed.
     * @return  true if collection is changed, false otherwise.
     */
    public boolean remove(T element) {
        if (isEmpty()){
        	return false;
        }
        Node n = front;
        while (n.element.compareTo(element) != 0 && n.next != null){
            n = n.next;
        }
        if (n.element.compareTo(element) == 0){
            if (n == front && n == rear){
                front = null;
                rear = null;
                size--;
                return true;
            }

            if (n == front){
                front = n.next;
                n.next.prev = null;
            }
            else if (n == rear){
                rear = n.prev;
                n.prev.next = null;
            }
            else{
                n.prev.next = n.next;
                n.next.prev = n.prev;
            }
            size--;
            return true; 
        }
        else{
            return false; 
        }
    }


    /**
     * Searches for specified element in this collection.
     *
     * @param   element  The element whose presence in this collection is to be tested.
     * @return  true if this collection contains the specified element, false otherwise.
     */
    public boolean contains(T element) {
        if (isEmpty()){
        	return false;
        }
        Node n = front;
        while (n.element.compareTo(element) != 0 && n.next != null){
            n = n.next;
        }
        if (n.element.compareTo(element) == 0){
            return true; 
        }
        else{
            return false; 
        }
    }


    /**
     * Tests for equality between this set and the parameter set.
     * Returns true if this set contains exactly the same elements
     * as the parameter set, regardless of order.
     *
     * @return  true if this set contains exactly the same elements as
     *               the parameter set, false otherwise
     */
    public boolean equals(Set<T> s) { //TODO test
        if (this.size() != s.size()){
            return false; 
        }
        for (T e: s){
            if (!this.contains(e)){
                return false; 
            }
        }
        return true; 
    }


    /**
     * Tests for equality between this set and the parameter set.
     * Returns true if this set contains exactly the same elements
     * as the parameter set, regardless of order.
     *
     * @return  true if this set contains exactly the same elements as
     *               the parameter set, false otherwise
     */
    public boolean equals(LinkedSet<T> s) { //TODO Test
        Node n = this.front;
        Node m = s.front;
        while (n != null && m !=null && n.element.compareTo(m.element) == 0){
            n = n.next;
            m = m.next;
        }
        if (n == null && m == null){
            return true;
        }
        else{
            return false; 
        }
    }


    /**
     * Returns a set that is the union of this set and the parameter set.
     *
     * @return  a set that contains all the elements of this set and the parameter set
     */
    public Set<T> union(Set<T> s){ 
        LinkedSet<T> out = new LinkedSet<>();
        for (T e: this){
            out.add(e);
            out.size++;
        }
        for (T e: s){
            out.add(e);
            out.size++;
        }
        return out;
    }


    /**
     * Returns a set that is the union of this set and the parameter set.
     *
     * @return  a set that contains all the elements of this set and the parameter set
     */
    public Set<T> union(LinkedSet<T> s){
        LinkedSet<T> out = new LinkedSet<>();
        Node n = this.front;
        Node m = s.front;
        if (n.element.compareTo(m.element) < 0){
            out.front = new Node(n.element);
            n = n.next;
        }
        else{
            out.front = new Node(m.element);
            m = m.next;
        }
        out.size++;
        Node p = out.front;
        //while (n != this.rear && m != s.rear){
        while (n != null && m != null){
            if (n.element.compareTo(m.element) == 0){
                Node nn = new Node(n.element);
                p.next = nn;
                nn.prev = p;

                p = p.next;
                n = n.next;
                m = m.next; //iterate both 
            }
            else if (n.element.compareTo(m.element) < 0){
                Node nn = new Node(n.element);
                p.next = nn;
                nn.prev = p;

                p = p.next;
                n = n.next;
            }
            else{
                Node mm = new Node(m.element);
                p.next = mm;
                mm.prev = p;
                
                p = p.next;
                m = m.next;
            }
            out.size++;
        }

        //n != this.rear
        if (n != null){
            while(n != null){
                Node nn = new Node(n.element);
                p.next = nn;
                nn.prev = p;

                p = p.next;
                n = n.next;
                out.size++;
            }
        }
        //m != s.rear
        else if (m != null){
            while(m != null){
                Node mm = new Node(m.element);
                p.next = mm;
                mm.prev = p;
                
                p = p.next;
                m = m.next;
                out.size++;
            }
        }

        out.rear = p;
        

        return out;
    }


    /**
     * Returns a set that is the intersection of this set and the parameter set.
     *
     * @return  a set that contains elements that are in both this set and the parameter set
     */
    public Set<T> intersection(Set<T> s) {
        Set<T> out = new LinkedSet<>();
        for (T e: s){
            if (this.contains(e)){
                out.add(e);
            }
        }
        return out; 
    }

    /**
     * Returns a set that is the intersection of this set and
     * the parameter set.
     *
     * @return  a set that contains elements that are in both
     *            this set and the parameter set
     */
    public Set<T> intersection(LinkedSet<T> s) {
        return null;
    }


    /**
     * Returns a set that is the complement of this set and the parameter set.
     *
     * @return  a set that contains elements that are in this set but not the parameter set
     */
    public Set<T> complement(Set<T> s) {
        return null;
    }


    /**
     * Returns a set that is the complement of this set and
     * the parameter set.
     *
     * @return  a set that contains elements that are in this
     *            set but not the parameter set
     */
    public Set<T> complement(LinkedSet<T> s) {
        return null;
    }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in ascending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     */
    public Iterator<T> iterator() {
        return new LinkedSetIterator<T>(this);
    }

    //making it T instead of E causes problems 
    class LinkedSetIterator<E> implements Iterator<T>{
        Node p;
        public LinkedSetIterator(LinkedSet<T> s)
        {
            p = s.front;
        }
        @Override
        public boolean hasNext() {
            if (p != null){
                return true;
            }
            return false;
        }
        @Override
        public T next() {
            T out = (T) p.element;
            p = p.next;
            return out; 
        }
    }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in descending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     */
    public Iterator<T> descendingIterator() {
        return null;
    }


    /**
     * Returns an iterator over the members of the power set
     * of this LinkedSet. No specific order can be assumed.
     *
     * @return  an iterator over members of the power set
     */
    public Iterator<Set<T>> powerSetIterator() {
        return null;
    }



    //////////////////////////////
    // Private utility methods. //
    //////////////////////////////

    // Feel free to add as many private methods as you need.

    ////////////////////
    // Nested classes //
    ////////////////////

    //////////////////////////////////////////////
    // DO NOT CHANGE THE NODE CLASS IN ANY WAY. //
    //////////////////////////////////////////////

    /**
     * Defines a node class for a doubly-linked list.
     */
    class Node {
        /** the value stored in this node. */
        T element;
        /** a reference to the node after this node. */
        Node next;
        /** a reference to the node before this node. */
        Node prev;

        /**
         * Instantiate an empty node.
         */
        public Node() {
            element = null;
            next = null;
            prev = null;
        }

        /**
         * Instantiate a node that containts element
         * and with no node before or after it.
         */
        public Node(T e) {
            element = e;
            next = null;
            prev = null;
        }
    }

}
