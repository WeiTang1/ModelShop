import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class TestJunit {
    @Test
    public void ProblemOneTest() {
       ProblemOne problemOne = new ProblemOne();
       assertEquals("\'A quick brown fox jumps over the lazy dog\' should return \"\" ","", problemOne.listMissingLetters("A quick brown fox jumps over the lazy dog"));
       assertEquals("empty string should return abc...z string","abcdefghijklmnopqrstuvwxyz", problemOne.listMissingLetters(""));
       assertEquals("\'Four score and seven years ago.\' should return \'bhijklmpqtwxz\'","bhijklmpqtwxz", problemOne.listMissingLetters("Four score and seven years ago."));

    }
    @Test
    public void ProblemTwoTest() {
        ProblemTwo problemTwo = new ProblemTwo();
        String[] result = {"..B....","<...>..","......>","......."};
        assertEquals(" ",true, Arrays.equals(result,problemTwo.explode("..B....", 2)));
        String[] result2 = {"..B.B..B","........"};
        assertEquals(" ",true, Arrays.equals(result2,problemTwo.explode("..B.B..B", 10)));

    }
    @Test(expected = NullPointerException.class)
    public void NullPointerExceptionTest() {
        ProblemOne problemOne = new ProblemOne();
        problemOne.listMissingLetters(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void BombsArgumentTest() {
        ProblemTwo problemTwo = new ProblemTwo();
        problemTwo.explode("",4);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ForceArgumentTest() {
        ProblemTwo problemTwo = new ProblemTwo();
        problemTwo.explode("...B...",99);
    }



}
