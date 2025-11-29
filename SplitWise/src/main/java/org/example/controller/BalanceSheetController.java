package org.example.controller;

import org.example.models.Balance;
import org.example.models.User;
import org.example.models.UserBalanceSheet;
import org.example.split.Split;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {
    public void updateBalanceSheet(List<Split> splits, User paidBy, double totalAmount){
        UserBalanceSheet paidByUserBalanceSheet = paidBy.getUserBalanceSheet();
        paidByUserBalanceSheet.setTotalPayments(paidByUserBalanceSheet.getTotalPayments() + totalAmount);

        for(Split split : splits){
            User owedToUser = split.getUser();
            UserBalanceSheet oweUserBalanceSheet = owedToUser.getUserBalanceSheet();
            double oweAmount = split.getAmount();

            // if the user who paid is the same as the user who owes
            // just update the total expense amount for the user
            if(owedToUser.getUserID().equals(paidBy.getUserID())){
                paidByUserBalanceSheet.setTotalExpense(paidByUserBalanceSheet.getTotalExpense()+ oweAmount);
                continue;
            }

            // Update in two places:
            // 1. Owe user's balance sheet
            // 2. Paid by user's balance sheet


            // 1. PaidBy user's balance sheet
            // Update the totalGetBack of the paidBy user's balance sheet (all users owe to paidBy user)
            paidByUserBalanceSheet.setTotalGetBack(paidByUserBalanceSheet.getTotalGetBack()+ oweAmount);

            // Update the totalGetBack of the owe user on paidBy user's balance sheet
            Balance userOweBalance;
            if(paidByUserBalanceSheet.getBalanceSheet().containsKey(owedToUser.getUserID())){
                userOweBalance = paidByUserBalanceSheet.getBalanceSheet().get(owedToUser.getUserID());
            }else{
                userOweBalance = new Balance();
                paidByUserBalanceSheet.getBalanceSheet().put(owedToUser.getUserID(), userOweBalance);
            }
            userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack()+oweAmount);

            // 2. owe user's balance sheet
            // Update the totalGetBack and totalExpenses of the oweUser user's balance sheet
            oweUserBalanceSheet.setTotalOwe(oweUserBalanceSheet.getTotalOwe()+ oweAmount);
            oweUserBalanceSheet.setTotalExpense(oweUserBalanceSheet.getTotalExpense()+oweAmount);

            // update the total owe balance to paidBy user on oweUser's balance sheet
            Balance paidByOweBalance;
            if(oweUserBalanceSheet.getBalanceSheet().containsKey(paidBy.getUserID())) {
                paidByOweBalance = oweUserBalanceSheet.getBalanceSheet().get(paidBy.getUserID());
            }else{
                paidByOweBalance = new Balance();
                oweUserBalanceSheet.getBalanceSheet().put(paidBy.getUserID(), paidByOweBalance);
            }

            paidByOweBalance.setAmountOwe(paidByOweBalance.getAmountOwe()+oweAmount);
        }
    }

    public void showBalanceSheetOfUser(User user){

        System.out.println("---------------------------------------");

        System.out.println("Balance sheet of user : " + user.getUserID());

        UserBalanceSheet userExpenseBalanceSheet =  user.getUserBalanceSheet();

        System.out.println("TotalYourExpense: " + userExpenseBalanceSheet.getTotalExpense());
        System.out.println("TotalGetBack: " + userExpenseBalanceSheet.getTotalGetBack());
        System.out.println("TotalYourOwe: " + userExpenseBalanceSheet.getTotalOwe());
        System.out.println("TotalPaymnetMade: " + userExpenseBalanceSheet.getTotalPayments());
        for(Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getBalanceSheet().entrySet()){

            String userID = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("userID:" + userID + " YouGetBack:" + balance.getAmountGetBack() + " YouOwe:" + balance.getAmountOwe());
        }

        System.out.println("---------------------------------------");

    }

}
