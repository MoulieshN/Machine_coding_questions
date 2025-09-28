package org.example.models;

public class Cell {
    private int row;
    private int col;
    private Player player;

    public Cell(int r, int c, Player player){
        this.row = r;
        this.col = c;
        this.player = player;
    }

    public int getRow(){
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getCol(){
        return col;
    }




}
