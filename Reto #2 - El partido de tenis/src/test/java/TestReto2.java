import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.vandresca.TennisGame;

public class TestReto2 {
    
    TennisGame tennisGame = null;

    @Before
    public void beforeTest(){
        tennisGame = new TennisGame();
    }

    @After
    public void afterTest(){
        tennisGame = null;
    }

    @Test
    public void showScoreBoard(){
        //Initial State LOVE-LOVE
        tennisGame.setWinner();
        Assert.assertEquals("LOVE - LOVE", tennisGame.showScoreBoard());
        tennisGame.getPlayer1().addPoint();
        tennisGame.setWinner();
        Assert.assertEquals("FIFTEEN - LOVE",  tennisGame.showScoreBoard());
        tennisGame.getPlayer2().addPoint();
        tennisGame.setWinner();
        Assert.assertEquals("FIFTEEN - FIFTEEN",  tennisGame.showScoreBoard());
        tennisGame.getPlayer1().addPoint();
        tennisGame.getPlayer1().addPoint();
        tennisGame.setWinner();
        Assert.assertEquals("FORTY - FIFTEEN",  tennisGame.showScoreBoard());
        tennisGame.getPlayer2().addPoint();
        tennisGame.getPlayer2().addPoint();
        tennisGame.setWinner();
        Assert.assertEquals("DEUCE",  tennisGame.showScoreBoard());
        tennisGame.getPlayer2().addPoint();
        tennisGame.setWinner();
        Assert.assertEquals("ADVANTAGE PLAYER 2",  tennisGame.showScoreBoard());
        tennisGame.getPlayer1().addPoint();
        tennisGame.setWinner();
        Assert.assertEquals("DEUCE",  tennisGame.showScoreBoard());
        tennisGame.getPlayer1().addPoint();
        tennisGame.setWinner();
        Assert.assertEquals("ADVANTAGE PLAYER 1",  tennisGame.showScoreBoard());
        tennisGame.getPlayer1().addPoint();
        tennisGame.setWinner();
        Assert.assertEquals("WIN PLAYER 1",  tennisGame.showScoreBoard());
    }

    @Test
    public void setWinner_and_hasWin(){
        Assert.assertTrue(!tennisGame.hasEnd()); //LOVE - LOVE
        tennisGame.getPlayer1().addPoint();
        tennisGame.setWinner();
        Assert.assertTrue(!tennisGame.hasEnd()); //FIFTEEN - LOVE
        tennisGame.getPlayer1().addPoint();
        tennisGame.setWinner();
        Assert.assertTrue(!tennisGame.hasEnd()); //THIRTY - LOVE
        tennisGame.getPlayer1().addPoint();
        tennisGame.setWinner();
        Assert.assertTrue(!tennisGame.hasEnd()); //FORTY - LOVE
        tennisGame.getPlayer1().addPoint();
        tennisGame.setWinner();
        Assert.assertTrue(tennisGame.hasEnd()); //PLAYER 1 WIN
    }

    @Test
    public void isDeuce(){
        Assert.assertTrue(!tennisGame.isDeuce()); //LOVE-LOVE
        tennisGame.getPlayer1().addPoint(); 
        Assert.assertTrue(!tennisGame.isDeuce()); //FIFTEEN-LOVE
        tennisGame.getPlayer1().addPoint(); 
        Assert.assertTrue(!tennisGame.isDeuce()); //THIRTY-LOVE
        tennisGame.getPlayer1().addPoint(); 
        Assert.assertTrue(!tennisGame.isDeuce()); //FORTY-LOVE
        tennisGame.getPlayer2().addPoint(); 
        Assert.assertTrue(!tennisGame.isDeuce()); //FORTY-FIFTEEN
        tennisGame.getPlayer2().addPoint(); 
        Assert.assertTrue(!tennisGame.isDeuce()); //FORTY-THIRTY
        tennisGame.getPlayer2().addPoint(); 
        Assert.assertTrue(tennisGame.isDeuce()); //DEUCE
        tennisGame.getPlayer2().addPoint();
        Assert.assertTrue(!tennisGame.isDeuce()); //ADVANTAGE PLAYER 2
        tennisGame.getPlayer1().addPoint(); 
        Assert.assertTrue(tennisGame.isDeuce()); //DEUCE
    }

    @Test
    public void isAdvantagePlayer1(){
        Assert.assertTrue(!tennisGame.isAdvantagePlayer1()); //LOVE-LOVE
        tennisGame.getPlayer1().addPoint(); 
        Assert.assertTrue(!tennisGame.isAdvantagePlayer1()); //FIFTEEN-LOVE
        tennisGame.getPlayer1().addPoint(); 
        Assert.assertTrue(!tennisGame.isAdvantagePlayer1()); //THIRTY-LOVE
        tennisGame.getPlayer1().addPoint(); 
        Assert.assertTrue(!tennisGame.isAdvantagePlayer1()); //FORTY-LOVE
        tennisGame.getPlayer2().addPoint(); 
        Assert.assertTrue(!tennisGame.isAdvantagePlayer1()); //FORTY-FIFTEEN
        tennisGame.getPlayer2().addPoint(); 
        Assert.assertTrue(!tennisGame.isAdvantagePlayer1()); //FORTY-THIRTY
        tennisGame.getPlayer2().addPoint(); 
        Assert.assertTrue(!tennisGame.isAdvantagePlayer1()); //DEUCE
        tennisGame.getPlayer1().addPoint(); 
        Assert.assertTrue(tennisGame.isAdvantagePlayer1());  //ADVANTAGE PLAYER 1
    }

    @Test
    public void isAdvantagePlayer2(){
        Assert.assertTrue(!tennisGame.isAdvantagePlayer2()); //LOVE-LOVE
        tennisGame.getPlayer1().addPoint(); 
        Assert.assertTrue(!tennisGame.isAdvantagePlayer2()); //FIFTEEN-LOVE
        tennisGame.getPlayer1().addPoint(); 
        Assert.assertTrue(!tennisGame.isAdvantagePlayer2()); //THIRTY-LOVE
        tennisGame.getPlayer1().addPoint(); 
        Assert.assertTrue(!tennisGame.isAdvantagePlayer2()); //FORTY-LOVE
        tennisGame.getPlayer2().addPoint(); 
        Assert.assertTrue(!tennisGame.isAdvantagePlayer2()); //FORTY-FIFTEEN
        tennisGame.getPlayer2().addPoint(); 
        Assert.assertTrue(!tennisGame.isAdvantagePlayer2()); //FORTY-THIRTY
        tennisGame.getPlayer2().addPoint(); 
        Assert.assertTrue(!tennisGame.isAdvantagePlayer2()); //DEUCE
        tennisGame.getPlayer2().addPoint(); 
        Assert.assertTrue(tennisGame.isAdvantagePlayer2());  //ADVANTAGE PLAYER 2

    }
}
