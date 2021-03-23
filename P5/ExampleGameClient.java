public class ExampleGameClient {
public static void main(String[] args) {
    WordSearchGame game = WordSearchGameFactory.createGame();
    game.loadLexicon("words.txt");
    game.setBoard(new String[]{"E", "E", "C", "A", "A", "L", "E", "P", "H", 
                                "N", "B", "O", "Q", "T", "T", "Y"});
    System.out.print("LENT is on the board at the following positions: ");
    System.out.println(game.isOnBoard("LENT"));
    System.out.print("POPE is not on the board: ");
    System.out.println(game.isOnBoard("POPE"));
    System.out.println("All words of length 6 or more: ");
    System.out.println(game.getAllScorableWords(6));
}
}
/*
LENT is on the board at the following positions: [5, 6, 9, 14]
POPE is not on the board: []
All words of length 6 or more: 
[ALEPOT, BENTHAL, PELEAN, TOECAP]
*/