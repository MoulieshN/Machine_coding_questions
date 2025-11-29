package org.example.states;

import org.example.VendingMachine;
import org.example.models.Item;

import java.util.Scanner;

public class HasMoneyState extends  State {

    public HasMoneyState(VendingMachine vendingMachine){
        super(vendingMachine);
    }


    @Override
    public void insertCoin() throws Exception {
        VendingMachine vendingMachine = this.getVendingMachine();
        System.out.println("Chosen product: " + vendingMachine.getChosenItem().type);
        double totalPrice = vendingMachine.getChosenItem().price;

        System.out.println("Total price: you need to pay: " + totalPrice);
        double amt = vendingMachine.getPaymentStrategy().pay();
        if(amt >= totalPrice) {
            double change = amt - totalPrice;
            this.getChange(change);
            try {
                vendingMachine.setCurrentState(new DispenseState(vendingMachine));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Insufficient amount paid. Refunding amount: " + amt);
            vendingMachine.setCurrentState(new IdleState(vendingMachine));
        }
    }

    @Override
    public void getChange(double change) throws Exception{
        if(change > 0){
            System.out.println("Please collect your change: " + change);
        }
    }




}
