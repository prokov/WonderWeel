package gameUnitTests;

public class Game {

    private Word word;
    private int balance;
    private int attempts;
    private int delta = 5;
    private int winKoef = 10;
    private int looseKoef = 5;


    public int getBalance() {
        return balance;
    }

    public int getAttempts() {
        return attempts;
    }

    public void startGame(String w, String d) {
        word = new Word(w, d);
    }

    public void openLetter(char letter) {

        int match = word.openLetter(letter);

        if (match == 0) balance -= delta;
        else

            balance += match * delta;

        attempts++;

    }

    public boolean isWin() {
        return word.isWin();

    }

    public void openWord(String w) throws WrongWordLengthException {
     //   attempts = attempts+1;
        if (word.openWord(w) == true) balance += delta * winKoef;
        else balance -= delta * looseKoef;
        attempts++;

    }


}
