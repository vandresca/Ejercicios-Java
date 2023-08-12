package com.vandresca.checkpuntuation;

import com.vandresca.Player;

public class CheckPlayer2Winner implements ICheckPuntuation {

    @Override
    public Boolean checkPuntuation(Player player1, Player player2) {
        return player2.isWinner();
    }

    @Override
    public String getValue() {
        return "WIN PLAYER 2";
    }
    
}
