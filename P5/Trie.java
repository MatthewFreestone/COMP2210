public class Trie{
	
	TrieNode root;
 
	public Trie(){
	   root = new TrieNode();
	}
 
	private class TrieNode{
	   TrieNode[] children = new TrieNode[26];
	   boolean leaf;
	   TrieNode(){
		  leaf = false;
		   // for (TrieNode child : children){
		   // 	child = null;
		   // }
	   }
	}
 
	public void insert(String wordIn){
	   String word = wordIn.toLowerCase(); 
	   TrieNode n = root;
	   for (char c : word.toCharArray()){
		  int l = letterIndex(c);
 
		  if (n.children[l] == null){
			 n.children[l] = new TrieNode();
		  }
 
		  n = n.children[l];
	   }
	   n.leaf = true;
	}
 
	private int letterIndex(char c){
	   return c - 'a';
	}
 
	public boolean containsWord(String wordIn){
	   String word = wordIn.toLowerCase(); 
	   TrieNode n = root;
	   for (char c : word.toCharArray()){
		  int l = letterIndex(c);
		  if (n.children[l] == null){
			 return false; 
		  }
		  n = n.children[l];
	   }
	   return n.leaf; //true if word ends there, false otherwise 
	}
 
	public boolean containsPrefix(String wordIn){
	   String word = wordIn.toLowerCase(); 
	   TrieNode n = root;
	   for (char c : word.toCharArray()){
		  int l = letterIndex(c);
		  if (n.children[l] == null){
			 return false; 
		  }
		  n = n.children[l];
	   }
	   return true; //true if word ends there, false otherwise 
	}
 
 }