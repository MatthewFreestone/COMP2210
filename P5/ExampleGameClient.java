public class ExampleGameClient {
public static void main(String[] args) {
    WordSearchGame game = WordSearchGameFactory.createGame();
    game.loadLexicon("words_medium.txt");
    game.setBoard(new String[]{"C","A","X","T"});


    System.out.println("All words of length 3 or more: ");
    System.out.println(game.getAllScorableWords(3));


    game = WordSearchGameFactory.createGame();
    game.loadLexicon("words_medium.txt");
    game.setBoard(new String[]{"X","X","X","X","X","X","X","X","X"});


    System.out.println("All words of length 7 or more: ");
    System.out.println(game.getAllScorableWords(7));
}
}
/*
LENT is on the board at the following positions: [5, 6, 9, 14]
POPE is not on the board: []
All words of length 6 or more: 
[ALEPOT, BENTHAL, PELEAN, TOECAP]
*/