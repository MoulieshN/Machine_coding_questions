package org.example;

import org.example.models.Coin;
import org.example.models.Item;
import org.example.states.IdleState;
import org.example.states.State;
import org.example.strategies.PaymentStrategy;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private State currentState;
    private PaymentStrategy paymentStrategy;
    private Map<Integer, Item> inventory;
    private Item chosenItem;

    VendingMachine(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
        this.inventory = new HashMap<>();
        this.currentState = new IdleState(this);
        this.chosenItem = null;
    }

    public Item getChosenItem() {
        return chosenItem;
    }

    public void setChosenItem(Item chosenItem) {
        this.chosenItem = chosenItem;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        System.out.println("State changed to: " + currentState.getClass().getSimpleName());
        this.currentState = currentState;
    }

    public Map<Integer, Item> getInventory() {
        return inventory;
    }

    public void setInventory(Map<Integer, Item> inventory) {
        this.inventory = inventory;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public Item getItem(int code) {
        if(inventory.containsKey(code)){
            return inventory.get(code);
        }
        return null;
    }
}
