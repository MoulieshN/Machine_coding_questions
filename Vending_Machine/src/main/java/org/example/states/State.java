package org.example.states;

import org.example.VendingMachine;
import org.example.models.Coin;

public abstract class State {
    private VendingMachine vendingMachine;
    State(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void clickOnInsertCoinButton() throws Exception{

    }
    public void insertCoin() throws Exception{

    }

    public void clickOnSelectProductButton() throws Exception{
        System.out.println("Select Product button clicked");
    }

    public void chooseProduct() throws Exception{

    }

    public void getChange(double change) throws Exception{

    }

    public void dispenseProduct() throws Exception{

    }

    public void refundFullAmount() throws Exception{

    }

    public void refillProducts() throws Exception{

    }
}
