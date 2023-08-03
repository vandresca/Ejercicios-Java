package src;
import java.util.Random;

public class TennisGame {
    
    private Player player1;

    private Player player2;
    
    public TennisGame(){
        init();
    }

    public void play(){
        while(!hasEnd()){
            setWinner();
            Printer.print(showScoreBoard());
            playGame(getWinner());
        }
    }

    private void init(){
        player1 = new Player();
        player2 = new Player();
    }


    private Boolean hasEnd(){
        return player1.isWinner() || player2.isWinner();
    }

    private void setWinner(){
        if(player1.isMoreThanFORTY() && differenceOfWin(player1, player2)) player1.setWinner();
        if(player2.isMoreThanFORTY() && differenceOfWin(player2, player1)) player2.setWinner();
    }

    private Boolean differenceOfWin(Player player1, Player player2){
        return (player1.getNumberPoints() - player2.getNumberPoints())>1;
    }

    private Player getWinner(){
        Random rd = new Random();
        return (rd.nextBoolean())? player1 : player2;
    }

    private void playGame(Player winner){
        winner.addPoint();
    }

    private String showScoreBoard(){
        if(isDeuce()) return "DEUCE";
        else if(isAdvantagePlayer1()) return "ADVANTAGE PLAYER 1";
        else if(isAdvantagePlayer2()) return "ADVANTAGE PLAYER 2";
        else if(player1.isWinner()) return "WIN PLAYER 1";
        else if(player2.isWinner()) return "WIN PLAYER 2";
        else return player1.getTypePoint() + " - " + player2.getTypePoint();
    }

    private Boolean isDeuce(){
        return player1.getNumberPoints()>= Player.TypePoint.FORTY.ordinal() && player1.getNumberPoints()== player2.getNumberPoints();
    }

    private Boolean isAdvantagePlayer1(){
        return (player1.getNumberPoints()> Player.TypePoint.FORTY.ordinal()) && (player1.getNumberPoints() - player2.getNumberPoints()==1);
    }

    private Boolean isAdvantagePlayer2(){
        return (player2.getNumberPoints()> Player.TypePoint.FORTY.ordinal()) && (player2.getNumberPoints() - player1.getNumberPoints()==1);
    }
}
