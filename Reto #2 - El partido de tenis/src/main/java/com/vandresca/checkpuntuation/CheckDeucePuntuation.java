package com.vandresca.checkpuntuation;

import com.vandresca.Player;

public class CheckDeucePuntuation implements ICheckPuntuation {

    @Override
    public Boolean checkPuntuation(Player player1, Player player2) {
        return player1.getNumberPoints()>= Player.TypePoint.FORTY.ordinal() && player1.getNumberPoints()== player2.getNumberPoints();
    }

    @Override
    public String getValue() {
        return "DEUCE";
    }    
}
