package gameUnitTests.gameUnitTests.tests;

import gameUnitTests.Game;
import gameUnitTests.Word;
import gameUnitTests.WrongWordLengthException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGame {

    Game game = new Game();

    @Before
    public void init(){
        game.startGame("procrastination", "description");
    }


    @Test
    public void startGame(){

        assertEquals(0,game.getAttempts());
        assertEquals (0,game.getBalance());
    }

    @Test
    public void attemptsCheck() throws WrongWordLengthException {

        game.openLetter('a');
        assertEquals(1,game.getAttempts());
        game.openLetter('x');
        assertEquals (2,game.getAttempts());
        game.openWord("gamificationaaa");
        assertEquals (3,game.getAttempts());
        game.openWord("procrastination");
        assertEquals (4,game.getAttempts());
    }


    @Test
    public void balanceCheck() throws WrongWordLengthException {

        game.openLetter('a');
        assertEquals(10,game.getBalance());
        game.openLetter('x');
        assertEquals (5,game.getBalance());
        game.openWord("gamificationaaa");
        assertEquals (-20,game.getBalance());
        game.openWord("procrastination");
        assertEquals (30,game.getBalance());
    }


}
