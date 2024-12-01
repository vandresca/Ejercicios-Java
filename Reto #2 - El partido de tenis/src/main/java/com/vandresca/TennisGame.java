package com.vandresca;
import java.util.Random;

import com.vandresca.checkpuntuation.CheckAdvantagePlayer1Puntuation;
import com.vandresca.checkpuntuation.CheckAdvantagePlayer2Puntuation;
import com.vandresca.checkpuntuation.CheckDeucePuntuation;
import com.vandresca.checkpuntuation.CheckPlayer1Winner;
import com.vandresca.checkpuntuation.CheckPlayer2Winner;
import com.vandresca.checkpuntuation.ICheckPuntuation;

public class TennisGame {
    
    private Player player1;

    private Player player2;

    private ICheckPuntuation[] iCheckPuntuations = {
        new CheckAdvantagePlayer1Puntuation(),
        new CheckAdvantagePlayer2Puntuation(),
        new CheckDeucePuntuation(),
        new CheckPlayer1Winner(),
        new CheckPlayer2Winner()
    };
    
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


    public Boolean hasEnd(){
        return player1.isWinner() || player2.isWinner();
    }

    public void setWinner(){
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

    public String showScoreBoard(){
        for(ICheckPuntuation iCheckPuntuation: iCheckPuntuations ){
            if(iCheckPuntuation.checkPuntuation(player1, player2)){
                return iCheckPuntuation.getValue();
            }
        }
        return player1.getTypePoint() + " - " + player2.getTypePoint();
    }

    public Player getPlayer1(){
        return player1;
    }

    public Player getPlayer2(){
        return player2;
    }
}
