
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Collections;

import java.util.stream.Collectors;

/**
 * Provides an implementation of the WordLadderGame interface. 
 *
 * @author Matthew Freestone (maf0083@auburn.edu)
 */
public class Doublets implements WordLadderGame {

    // The word list used to validate words.
    // Must be instantiated and populated in the constructor.
    /////////////////////////////////////////////////////////////////////////////
    // DECLARE A FIELD NAMED lexicon HERE. THIS FIELD IS USED TO STORE ALL THE //
    // WORDS IN THE WORD LIST. YOU CAN CREATE YOUR OWN COLLECTION FOR THIS     //
    // PURPOSE OF YOU CAN USE ONE OF THE JCF COLLECTIONS. SUGGESTED CHOICES    //
    // ARE TreeSet (a red-black tree) OR HashSet (a closed addressed hash      //
    // table with chaining).
    /////////////////////////////////////////////////////////////////////////////

    HashSet<String> lexicon; 
    /**
     * Instantiates a new instance of Doublets with the lexicon populated with
     * the strings in the provided InputStream. The InputStream can be formatted
     * in different ways as long as the first string on each line is a word to be
     * stored in the lexicon.
     */
    public Doublets(InputStream in) {
        try {
            //////////////////////////////////////
            // INSTANTIATE lexicon OBJECT HERE  //
            //////////////////////////////////////
            lexicon = new HashSet<>(); 
            Scanner s =
                new Scanner(new BufferedReader(new InputStreamReader(in)));
            while (s.hasNext()) {
                String str = s.next();
                /////////////////////////////////////////////////////////////
                // INSERT CODE HERE TO APPROPRIATELY STORE str IN lexicon. //
                /////////////////////////////////////////////////////////////
                lexicon.add(str.toLowerCase());
                s.nextLine();
            }
            in.close();
        }
        catch (java.io.IOException e) {
            System.err.println("Error reading from InputStream.");
            System.exit(1);
        }
    }

    @Override
    public int getWordCount() {
        return lexicon.size();
    }
    @Override
    public boolean isWord(String str) {
        return lexicon.contains(str);
    }
    @Override
    public int getHammingDistance(String str1, String str2) {
        if (str1.length() != str2.length()){
            return -1; 
        }
        int distance = 0; 
        for (int i = 0; i < str1.length(); i++){
            if (str1.charAt(i) != str2.charAt(i)){
                distance++;
            }
        }
        return distance;
    }

    @Override
    public List<String> getNeighbors(String word) {
        char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] checking = word.toCharArray();
        List<String> neighbors = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++){
            for (char c : ALPHABET){
                checking[i] = c;
                String newWord = new String(checking);
                if (!word.equals(newWord) && isWord(newWord)){
                    neighbors.add(newWord);
                }
            }
            checking = word.toCharArray();
        }
        return neighbors;
    }
    @Override
    public boolean isWordLadder(List<String> sequence) {
        if (sequence.size() == 0){
            return false; 
        }
        for (int i = 1; i < sequence.size(); i++){
            if (getHammingDistance(sequence.get(i-1), sequence.get(i)) != 1 || !isWord(sequence.get(i))){
                return false; 
            }
        }
        return true;
    }
    @Override
    public List<String> getMinLadder(String start, String end) {
        List<String> out = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        if (start == end){
            out.add(start);
            return out;
        }
        if (getHammingDistance(start, end) == 1){
            out.add(start);
            out.add(end);
            return out; 
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(start));
        visited.add(start);
        while(!queue.isEmpty()){
            Node c = queue.removeFirst();
            String c_str = c.e;
            List<String> neighbors = getNeighbors(c_str);
            for (String word : neighbors){ //check to make sure it doesn't get worse dist
                //if (!c.contains(word)){
                if (!visited.contains(word)){
                    visited.add(word);
                    if (word.equals(end)){
                        out.add(word);
                        out.add(c.e);
                        Node n = c.prev;
                        while (n != null){
                            out.add(n.e);
                            n = n.prev;
                        }
                        Collections.reverse(out);
                        return out; 
                    }
                    queue.addLast(new Node(word, c));
                }

            }
        }
        return out;
    }



    private class Node {
        Node prev;
        String e;
        Node(String e){
            this.e = e;
            this.prev = null;
        }
        Node(String e, Node prev){
            this.e = e;
            this.prev = prev;
        }

        boolean contains(String s){
            if (e.equals(s)){
                return true;
            }
            Node c = this.prev;
            while(c != null){
                if (c.e.equals(s)){
                    return true;
                }
                c = c.prev;
            }
            return false; 
        }
    }
    //////////////////////////////////////////////////////////////
    // ADD IMPLEMENTATIONS FOR ALL WordLadderGame METHODS HERE  //
    //////////////////////////////////////////////////////////////

}
