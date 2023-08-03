import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import src.Player;
import src.TennisGame;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestTennisGame {
    
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
    public void testGetWinner(){
        try {
            Method getWinner = TennisGame.class.getDeclaredMethod("getWinner");
            getWinner.setAccessible(true);
            Object object = getWinner.invoke(tennisGame);
            Assert.assertTrue(object instanceof Player);
            getWinner.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void showScoreBoard(){
        try {
            Field field1 = TennisGame.class.getDeclaredField("player1");
            Field field2 = TennisGame.class.getDeclaredField("player2");
            Method showScoreBoard = TennisGame.class.getDeclaredMethod("showScoreBoard");
            Method setWinner = TennisGame.class.getDeclaredMethod("setWinner");
            field1.setAccessible(true);
            field2.setAccessible(true);
            showScoreBoard.setAccessible(true);
            setWinner.setAccessible(true);
            Player player1 = (Player)field1.get(tennisGame);
            Player player2 = (Player)field2.get(tennisGame);
            //Initial State LOVE-LOVE
            setWinner.invoke(tennisGame);
            String result  = (String) showScoreBoard.invoke(tennisGame);
            Assert.assertEquals("LOVE - LOVE", result);
            player1.addPoint();
            setWinner.invoke(tennisGame);
            result  = (String) showScoreBoard.invoke(tennisGame);
            Assert.assertEquals("FIFTEEN - LOVE", result);
            player2.addPoint();
            setWinner.invoke(tennisGame);
            result  = (String) showScoreBoard.invoke(tennisGame);
            Assert.assertEquals("FIFTEEN - FIFTEEN", result);
            player1.addPoint();
            player1.addPoint();
            setWinner.invoke(tennisGame);
            result  = (String) showScoreBoard.invoke(tennisGame);
            Assert.assertEquals("FORTY - FIFTEEN", result);
            player2.addPoint();
            player2.addPoint();
            setWinner.invoke(tennisGame);
            result  = (String) showScoreBoard.invoke(tennisGame);
            Assert.assertEquals("DEUCE", result);
            player2.addPoint();
            setWinner.invoke(tennisGame);
            result  = (String) showScoreBoard.invoke(tennisGame);
            Assert.assertEquals("ADVANTAGE PLAYER 2", result);
            player1.addPoint();
            setWinner.invoke(tennisGame);
            result  = (String) showScoreBoard.invoke(tennisGame);
            Assert.assertEquals("DEUCE", result);
            player1.addPoint();
            setWinner.invoke(tennisGame);
            result  = (String) showScoreBoard.invoke(tennisGame);
            Assert.assertEquals("ADVANTAGE PLAYER 1", result);
            player1.addPoint();
            setWinner.invoke(tennisGame);
            result  = (String) showScoreBoard.invoke(tennisGame);
            Assert.assertEquals("WIN PLAYER 1", result);
            
            field1.setAccessible(false);
            field2.setAccessible(false);
            showScoreBoard.setAccessible(false);
            setWinner.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setWinner_and_hasWin(){
        try{
            Field field1 = TennisGame.class.getDeclaredField("player1");
            Method setWinner = TennisGame.class.getDeclaredMethod("setWinner");
            Method hasWin = TennisGame.class.getDeclaredMethod("hasWin");
            Player player1 = (Player)field1.get(tennisGame);

            setWinner.setAccessible(true);
            hasWin.setAccessible(true);
            field1.setAccessible(true);

            setWinner.invoke(tennisGame);
            player1.addPoint();
            Assert.assertTrue(!(Boolean)hasWin.invoke(tennisGame));
            setWinner.invoke(tennisGame);
            player1.addPoint();
            Assert.assertTrue(!(Boolean)hasWin.invoke(tennisGame));
            setWinner.invoke(tennisGame);
            player1.addPoint();
            Assert.assertTrue(!(Boolean)hasWin.invoke(tennisGame));
            setWinner.invoke(tennisGame);
            player1.addPoint();
            Assert.assertTrue((Boolean)hasWin.invoke(tennisGame));

            setWinner.setAccessible(false);
            hasWin.setAccessible(false);
            field1.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isDeuce(){
        try{
            Field field1 = TennisGame.class.getDeclaredField("player1");
            Field field2 = TennisGame.class.getDeclaredField("player2");
            Method isDeuce = TennisGame.class.getDeclaredMethod("isDeuce");
            Player player1 = (Player)field1.get(tennisGame);
            Player player2 = (Player)field2.get(tennisGame);

            field1.setAccessible(true);
            field2.setAccessible(true);
            isDeuce.setAccessible(true);

            Assert.assertTrue(!(Boolean)isDeuce.invoke(tennisGame)); //LOVE-LOVE
            player1.addPoint(); 
            Assert.assertTrue(!(Boolean)isDeuce.invoke(tennisGame)); //FIFTEEN-LOVE
            player1.addPoint(); 
            Assert.assertTrue(!(Boolean)isDeuce.invoke(tennisGame)); //THIRTY-LOVE
            player1.addPoint(); 
            Assert.assertTrue(!(Boolean)isDeuce.invoke(tennisGame)); //FORTY-LOVE
            player2.addPoint(); 
            Assert.assertTrue(!(Boolean)isDeuce.invoke(tennisGame)); //FORTY-FIFTEEN
            player2.addPoint(); 
            Assert.assertTrue(!(Boolean)isDeuce.invoke(tennisGame)); //FORTY-THIRTY
            player2.addPoint(); 
            Assert.assertTrue((Boolean)isDeuce.invoke(tennisGame)); //DEUCE

            field1.setAccessible(false);
            field2.setAccessible(false);
            isDeuce.setAccessible(false);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void isAdvantagePlayer1(){
         try{
            Field field1 = TennisGame.class.getDeclaredField("player1");
            Field field2 = TennisGame.class.getDeclaredField("player2");
            Method isAdvantagePlayer1 = TennisGame.class.getDeclaredMethod("isAdvantagePlayer1");
            Player player1 = (Player)field1.get(tennisGame);
            Player player2 = (Player)field2.get(tennisGame);

            field1.setAccessible(true);
            field2.setAccessible(true);
            isAdvantagePlayer1.setAccessible(true);

            Assert.assertTrue(!(Boolean)isAdvantagePlayer1.invoke(tennisGame)); //LOVE-LOVE
            player1.addPoint(); 
            Assert.assertTrue(!(Boolean)isAdvantagePlayer1.invoke(tennisGame)); //FIFTEEN-LOVE
            player1.addPoint(); 
            Assert.assertTrue(!(Boolean)isAdvantagePlayer1.invoke(tennisGame)); //THIRTY-LOVE
            player1.addPoint(); 
            Assert.assertTrue(!(Boolean)isAdvantagePlayer1.invoke(tennisGame)); //FORTY-LOVE
            player2.addPoint(); 
            Assert.assertTrue(!(Boolean)isAdvantagePlayer1.invoke(tennisGame)); //FORTY-FIFTEEN
            player2.addPoint(); 
            Assert.assertTrue(!(Boolean)isAdvantagePlayer1.invoke(tennisGame)); //FORTY-THIRTY
            player2.addPoint(); 
            Assert.assertTrue(!(Boolean)isAdvantagePlayer1.invoke(tennisGame)); //DEUCE
            player1.addPoint(); 
            Assert.assertTrue((Boolean)isAdvantagePlayer1.invoke(tennisGame));  //ADVANTAGE PLAYER 1


            field1.setAccessible(false);
            field2.setAccessible(false);
            isAdvantagePlayer1.setAccessible(false);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void isAdvantagePlayer2(){
         try{
            Field field1 = TennisGame.class.getDeclaredField("player1");
            Field field2 = TennisGame.class.getDeclaredField("player2");
            Method isAdvantagePlayer2 = TennisGame.class.getDeclaredMethod("isAdvantagePlayer2");
            Player player1 = (Player)field1.get(tennisGame);
            Player player2 = (Player)field2.get(tennisGame);

            field1.setAccessible(true);
            field2.setAccessible(true);
            isAdvantagePlayer2.setAccessible(true);

            Assert.assertTrue(!(Boolean)isAdvantagePlayer2.invoke(tennisGame)); //LOVE-LOVE
            player1.addPoint(); 
            Assert.assertTrue(!(Boolean)isAdvantagePlayer2.invoke(tennisGame)); //FIFTEEN-LOVE
            player1.addPoint(); 
            Assert.assertTrue(!(Boolean)isAdvantagePlayer2.invoke(tennisGame)); //THIRTY-LOVE
            player1.addPoint(); 
            Assert.assertTrue(!(Boolean)isAdvantagePlayer2.invoke(tennisGame)); //FORTY-LOVE
            player2.addPoint(); 
            Assert.assertTrue(!(Boolean)isAdvantagePlayer2.invoke(tennisGame)); //FORTY-FIFTEEN
            player2.addPoint(); 
            Assert.assertTrue(!(Boolean)isAdvantagePlayer2.invoke(tennisGame)); //FORTY-THIRTY
            player2.addPoint(); 
            Assert.assertTrue(!(Boolean)isAdvantagePlayer2.invoke(tennisGame)); //DEUCE
            player2.addPoint(); 
            Assert.assertTrue((Boolean)isAdvantagePlayer2.invoke(tennisGame));  //ADVANTAGE PLAYER 2
        
            field1.setAccessible(false);
            field2.setAccessible(false);
            isAdvantagePlayer2.setAccessible(false);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
