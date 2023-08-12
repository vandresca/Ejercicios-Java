package com.vandresca.checkpuntuation;

import com.vandresca.Player;

public class CheckAdvantagePlayer1Puntuation implements ICheckPuntuation {
       @Override
    public Boolean checkPuntuation(Player player1, Player player2) {
        return (player1.getNumberPoints()> Player.TypePoint.FORTY.ordinal()) && (player1.getNumberPoints() - player2.getNumberPoints()==1);
    }

    @Override
    public String getValue() {
        return "ADVANTAGE PLAYER 1";
    }    
}
