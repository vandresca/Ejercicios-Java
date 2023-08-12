import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vandresca.Player;
import com.vandresca.TennisGame;
import com.vandresca.checkpuntuation.CheckAdvantagePlayer1Puntuation;
import com.vandresca.checkpuntuation.CheckAdvantagePlayer2Puntuation;
import com.vandresca.checkpuntuation.CheckDeucePuntuation;

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
        CheckDeucePuntuation checkDeuceP = new CheckDeucePuntuation();
        Player player1 = tennisGame.getPlayer1();
        Player player2 = tennisGame.getPlayer2();

        Assert.assertTrue(!checkDeuceP.checkPuntuation(player1, player2)); //LOVE-LOVE
        tennisGame.getPlayer1().addPoint(); 
        Assert.assertTrue(!checkDeuceP.checkPuntuation(player1, player2)); //FIFTEEN-LOVE
        tennisGame.getPlayer1().addPoint(); 
        Assert.assertTrue(!checkDeuceP.checkPuntuation(player1, player2)); //THIRTY-LOVE
        tennisGame.getPlayer1().addPoint(); 
        Assert.assertTrue(!checkDeuceP.checkPuntuation(player1, player2)); //FORTY-LOVE
        tennisGame.getPlayer2().addPoint(); 
        Assert.assertTrue(!checkDeuceP.checkPuntuation(player1, player2)); //FORTY-FIFTEEN
        tennisGame.getPlayer2().addPoint(); 
        Assert.assertTrue(!checkDeuceP.checkPuntuation(player1, player2)); //FORTY-THIRTY
        tennisGame.getPlayer2().addPoint(); 
        Assert.assertTrue(checkDeuceP.checkPuntuation(player1, player2)); //DEUCE
        tennisGame.getPlayer2().addPoint();
        Assert.assertTrue(!checkDeuceP.checkPuntuation(player1, player2)); //ADVANTAGE PLAYER 2
        tennisGame.getPlayer1().addPoint(); 
        Assert.assertTrue(checkDeuceP.checkPuntuation(player1, player2)); //DEUCE
    }

    @Test
    public void isAdvantagePlayer1(){
        CheckAdvantagePlayer1Puntuation checkAPlayer1P = new CheckAdvantagePlayer1Puntuation();
        Player player1 = tennisGame.getPlayer1();
        Player player2 = tennisGame.getPlayer2();

        Assert.assertTrue(!checkAPlayer1P.checkPuntuation(player1,player2)); //LOVE-LOVE
        player1.addPoint(); 
        Assert.assertTrue(!checkAPlayer1P.checkPuntuation(player1,player2)); //FIFTEEN-LOVE
        player1.addPoint(); 
        Assert.assertTrue(!checkAPlayer1P.checkPuntuation(player1,player2)); //THIRTY-LOVE
        player1.addPoint(); 
        Assert.assertTrue(!checkAPlayer1P.checkPuntuation(player1,player2)); //FORTY-LOVE
        player2.addPoint(); 
        Assert.assertTrue(!checkAPlayer1P.checkPuntuation(player1,player2)); //FORTY-FIFTEEN
        player2.addPoint(); 
        Assert.assertTrue(!checkAPlayer1P.checkPuntuation(player1,player2)); //FORTY-THIRTY
        player2.addPoint(); 
        Assert.assertTrue(!checkAPlayer1P.checkPuntuation(player1,player2)); //DEUCE
        player1.addPoint(); 
        Assert.assertTrue(checkAPlayer1P.checkPuntuation(player1,player2));  //ADVANTAGE PLAYER 1
    }

    @Test
    public void isAdvantagePlayer2(){
        CheckAdvantagePlayer2Puntuation checkAPlayer2P = new CheckAdvantagePlayer2Puntuation();
        Player player1 = tennisGame.getPlayer1();
        Player player2 = tennisGame.getPlayer2();
        
        Assert.assertTrue(!checkAPlayer2P.checkPuntuation(player1,player2)); //LOVE-LOVE
        player1.addPoint(); 
        Assert.assertTrue(!checkAPlayer2P.checkPuntuation(player1,player2)); //FIFTEEN-LOVE
        player1.addPoint(); 
        Assert.assertTrue(!checkAPlayer2P.checkPuntuation(player1,player2)); //THIRTY-LOVE
        player1.addPoint(); 
        Assert.assertTrue(!checkAPlayer2P.checkPuntuation(player1,player2)); //FORTY-LOVE
        player2.addPoint(); 
        Assert.assertTrue(!checkAPlayer2P.checkPuntuation(player1,player2)); //FORTY-FIFTEEN
        player2.addPoint(); 
        Assert.assertTrue(!checkAPlayer2P.checkPuntuation(player1,player2)); //FORTY-THIRTY
        player2.addPoint(); 
        Assert.assertTrue(!checkAPlayer2P.checkPuntuation(player1,player2)); //DEUCE
        player2.addPoint(); 
        Assert.assertTrue(checkAPlayer2P.checkPuntuation(player1,player2));  //ADVANTAGE PLAYER 2

    }
}
