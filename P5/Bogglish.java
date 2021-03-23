import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Bogglish implements WordSearchGame{

   private Trie dict;
   private String[][] board;
   private String[] flatBoard;
   private SortedSet<String> foundWords;
   private ArrayList<Integer>[] adjList;
   private int V;
   private boolean loaded;

   public Bogglish(){
      dict = new Trie();
      board = null;
      flatBoard = null;
      adjList = null;
      foundWords = new TreeSet<String>();
      V = 0;
      loaded = false;
   }

   @Override
   public void loadLexicon(String fileName) {
      FileInputStream inputStream = null;
      Scanner fileIO = null;
      if (fileName == null){
         throw new IllegalArgumentException();
      }
      try{
         inputStream = new FileInputStream(fileName);
         fileIO = new Scanner(inputStream, "UTF-8");
      }
      catch(FileNotFoundException e){
         throw new IllegalArgumentException();
      }
      while(fileIO.hasNextLine()){
         String line = fileIO.nextLine();
         Scanner t = new Scanner(line);
         String toAdd = t.next();
         t.close();
         dict.insert(toAdd);
      }
      fileIO.close();
      loaded = true;
   }


   @Override
   public void setBoard(String[] letterArray) {
      if(letterArray == null){
          throw new IllegalArgumentException();
      }
      int size = (int) Math.floor(Math.sqrt(letterArray.length));
      if (size*size != letterArray.length){
         throw new IllegalArgumentException();
      }
      V = (int)Math.pow(size, 2);
      board = new String[size][size];
      flatBoard = letterArray.clone();
      for (int i = 0; i < size; i++){
         for (int j = 0; j < size; j++){
            board[i][j] = letterArray[i*size + j];
         }
      }
      createAdjList(); 
   }

   @SuppressWarnings("unchecked")
   private void createAdjList(){
      adjList = new ArrayList[V];
      for (int i = 0; i < V; i++){
         adjList[i] = new ArrayList<Integer>();
      }
      //fill in matrix 
      for (int i = 0; i < V; i++){
         int[] xy = fromRM(i);
         int x= xy[0];
         int y= xy[1];
         int[] around = {-1,0,1};
      
         for (int dx : around){
            for (int dy: around){
               if ((dx != 0 || dy !=0) && validIndex(x + dx, y + dy)){
                  adjList[i].add(toRM(x + dx, y + dy));
               }
            }
         }
      }
   }

   private boolean validIndex(int x, int y){
      return (x >= 0 && y>=0 && x<board.length && y<board.length);
   }


      
       
       


   @Override
   public String getBoard() {
      String out = "";
      if (board == null){
         return out; 
      }
      for (String[] line : board){
         for (String s : line){
            out += s + " ";
         }
         out += "\n";
      }
      return out; 
   }

   @Override
   public SortedSet<String> getAllScorableWords(int minimumWordLength) {
       foundWords = new TreeSet<String>();
      if (minimumWordLength < 1){
         throw new IllegalArgumentException();
      }
      if (!loaded){
         throw new IllegalStateException();
      }
      //createAdjList();
      for (int i = 0; i < V; i++){
         boolean[] visited = new boolean[V];
         ArrayList<Integer> path = new ArrayList<>();
         path.add(i);
         getScoreableDFS(i, visited, path,minimumWordLength);
      }
      return foundWords;
   }


   // private void wordsDFS(int c, boolean[] visited, List<Integer> path){
   //     visited[c] = true;
   //     for (Integer i : adjList[c]){
   //         if (!visited[i]){
   //             path.add(i);
   //             System.out.println(path.toString()); //TODO
   //             wordsDFS(i, visited, path);
   //             path.remove(path.size()-1);
   //             //path.remove(i); //used to be this; very slow
   //         }
   //     }
   //     visited[c] = false;
   // }


   private void getScoreableDFS(int c, boolean[] visited, List<Integer> path, int minLen){
      visited[c] = true;
      String curString = pathToString(path);
      if (!isValidPrefix(curString)){
        visited[c] = false;
        return;
      }
      if(curString.length() >= minLen && isValidWord(curString)){
         foundWords.add(curString);
      }
      for (Integer i : adjList[c]){
         if (!visited[i]){
            path.add(i);
            getScoreableDFS(i, visited, path,minLen);
            path.remove(path.size()-1);
            //path.remove(i); //used to be this; very slow
         }
      }
      visited[c] = false;
   }

   private String pathToString(List<Integer> path){
      String out = "";
      for (int i: path){
         out += flatBoard[i];
      }
      return out;
   }


   @Override
   public int getScoreForWords(SortedSet<String> words, int minimumWordLength) {
      if (minimumWordLength < 1){
         throw new IllegalArgumentException();
      }
      if (!loaded){
         throw new IllegalStateException();
      }
      int total = 0;
      for (String word : words){
         if (word.length() >= minimumWordLength && isValidWord(word) && (this.isOnBoard(word).size() != 0)){
            total += (word.length() - minimumWordLength) + 1;
         }
      }
      return total;
   }


   @Override
   public boolean isValidWord(String wordToCheck) {
      if (wordToCheck == null){
         throw new IllegalArgumentException();
      }
      if (!loaded){
         throw new IllegalStateException() ;
      }
      return dict.containsWord(wordToCheck);
   }
   @Override
   public boolean isValidPrefix(String prefixToCheck) {
      if (prefixToCheck == null){
         throw new IllegalArgumentException();
      }
      if (!loaded){
         throw new IllegalStateException();
      }
      return dict.containsPrefix(prefixToCheck);
   }



   @Override
   public List<Integer> isOnBoard(String wordToCheck) {
      if (wordToCheck == null){
         throw new IllegalArgumentException();
      }
      if (!loaded){
         throw new IllegalStateException();
      }
      Trie onBTrie = new Trie();
      onBTrie.insert(wordToCheck);
      List<Integer> result;
      for (int i = 0; i < V; i++){
         boolean[] visited = new boolean[V];
         ArrayList<Integer> path = new ArrayList<>();
         path.add(i);
         result = onBoardDFS(i, visited, path, onBTrie);
         if (result != null){
            return result;
         }
      }
      return new ArrayList<>(); //return empty list if not on board
   }
   private List<Integer> onBoardDFS(int c, boolean[] visited, List<Integer> path, Trie onBTrie){
      visited[c] = true;
      String curString = pathToString(path);
      
      if (onBTrie.containsWord(curString)){ //equivalent to wordToCheck.equals(curString)
         return path;
      }
      if (onBTrie.containsPrefix(curString)){
         for (Integer i : adjList[c]){
            if (!visited[i]){
               path.add(i);
               List<Integer> result = onBoardDFS(i, visited, path, onBTrie);
               if (result != null){
                  return result;
               }
               path.remove(path.size()-1);
            }
         }
      }
      visited[c] = false;
      return null;
   }





   /**
    * Changes n from row-major to x and y
    * @param n Row major number
    * @return [x,y] as int array of size 2
    */
   private int[] fromRM(int n){
      int[] out = new int[2];
      out[0] = n%board.length; //x
      out[1] = n/board.length; //y
      return out; 
   }

   private int toRM(int x, int y){
      return (y*board.length + x);
   }

}
