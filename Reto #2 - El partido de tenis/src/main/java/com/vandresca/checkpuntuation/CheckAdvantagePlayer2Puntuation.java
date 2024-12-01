package com.vandresca.checkpuntuation;

import com.vandresca.Player;

public class CheckAdvantagePlayer2Puntuation implements ICheckPuntuation{
    
    @Override
    public Boolean checkPuntuation(Player player1, Player player2) {
        return (player2.getNumberPoints()> Player.TypePoint.FORTY.ordinal()) && (player2.getNumberPoints() - player1.getNumberPoints()==1);
    }

    @Override
    public String getValue() {
        return "ADVANTAGE PLAYER 2";
    }    
}
