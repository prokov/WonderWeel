package gameUnitTests.gameUnitTests.tests;

import gameUnitTests.Word;
import gameUnitTests.WrongWordLengthException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestWord {

    Word word = new Word("apple", "some description");

    @Test
    public void testGetWordWithStars() {

        Word word = new Word("apple", "some description");
        assertEquals("*****", word.getWordWithStars());

    }

    @Test //lower, capital case, special symbols, cyrillic
    public void testOpenLetterValidChar() {

        word.openLetter('a');
        assertEquals("a****", word.getWordWithStars());


        word.openLetter('b');
        assertEquals("a****", word.getWordWithStars());

        word.openLetter('p');
        assertEquals("app**", word.getWordWithStars());

        word.openLetter('а');
        assertEquals("app**", word.getWordWithStars());


    }

    @Test //lower, capital case, special symbols, cyrillic
    public void testInvalidLetter() {

        Word word = new Word("apple", "some description");

        word.openLetter('A');
        assertEquals("*****", word.getWordWithStars());


        word.openLetter('%');
        assertEquals("*****", word.getWordWithStars());


        word.openLetter('р'); //cyrillic
        assertEquals("*****", word.getWordWithStars());


    }


    @Test //valid word
    public void testOpenWordValid() throws WrongWordLengthException {

        word.openWord("apple");
        assertEquals("apple", word.getWordWithStars());


    }

    @Test(expected = WrongWordLengthException.class) //invalid word length
    public void testOpenWordInvalidLength() throws WrongWordLengthException {

        Word word = new Word("apple", "some description");

        word.openWord("longword");


    }

    @Test //valid word
    public void isWinWord() throws WrongWordLengthException {

        word.openWord("apple");
        assertEquals(true, word.isWin());


    }

    @Test //valid word
    public void isWinLetters() throws WrongWordLengthException {

        word.openLetter('a');
        word.openLetter('p');
        word.openLetter('p');
      //  word.openLetter('l');
        word.openLetter('e');


        assertEquals(false, word.isWin());


    }


}
