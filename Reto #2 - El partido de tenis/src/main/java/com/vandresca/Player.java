package com.vandresca;

public class Player {
    private int points;

    private Boolean winner;

    public enum TypePoint {
        LOVE, FIFTEEN, THIRTY, FORTY;
    }

    public Player() {
        this.points = 0;
        this.winner = false;
    }

    public int getNumberPoints(){
        return this.points;
    }

    public TypePoint getTypePoint(){
        return switch(this.points){
            case 0 -> TypePoint.LOVE;
            case 1 -> TypePoint.FIFTEEN;
            case 2 -> TypePoint.THIRTY;
            default -> TypePoint.FORTY;
        };
    }

    public void addPoint(){
        this.points++;
    }

    public Boolean isMoreThanFORTY(){
        return this.points > TypePoint.FORTY.ordinal();
    }

    public void setWinner(){
        this.winner = true;
    }

    public Boolean isWinner(){
        return this.winner;
    }
}
