package org.example.models;

import org.example.enums.CellState;

public class Cell {
    private int row;
    private int col;
    private Item item; // item could
    private CellState state;


    public Cell(int row, int col, Item item){
        this.row = row;
        this.col = col;
        this.item = item;
        this.state = CellState.EMPTY;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}