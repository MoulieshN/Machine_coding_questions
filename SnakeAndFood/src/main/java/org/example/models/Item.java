package org.example.models;


public abstract  class Item {
    private String utf;
    protected int points;
    Item(String utf) {
        this.utf = utf;
    }

    public String getUtf() {
        return utf;
    }

    public void setUtf(String utf) {
        this.utf = utf;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
