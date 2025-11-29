package org.example;

import org.example.controller.BalanceSheetController;
import org.example.controller.GroupController;
import org.example.controller.UserController;
import org.example.enums.ExpenseSplitType;
import org.example.models.Group;
import org.example.models.User;
import org.example.split.Split;

import java.util.ArrayList;
import java.util.List;

public class SplitWise {
    UserController userController;
    GroupController groupController;

    BalanceSheetController balanceSheetController;

    SplitWise(){
        userController = new UserController();
        groupController = new GroupController();
        balanceSheetController = new BalanceSheetController();
    }

    public void demo(){

        setupUserAndGroup();

        //Step1: add members to the group
        Group group = groupController.getGroupById("G1001");
        group.addMember(userController.getUserById("U2001"));
        group.addMember(userController.getUserById("U3001"));

        //Step2. create an expense inside a group
        List<Split> splits = new ArrayList<>();
        Split split1 = new Split(userController.getUserById("U1001"), 300);
        Split split2 = new Split(userController.getUserById("U2001"), 300);
        Split split3 = new Split(userController.getUserById("U3001"), 300);
        splits.add(split1);
        splits.add(split2);
        splits.add(split3);
        group.createExpense("Exp1001", "Breakfast", 900, splits, userController.getUserById("U1001"), ExpenseSplitType.EQUAL);

//        List<Split> splits2 = new ArrayList<>();
//        Split splits2_1 = new Split(userController.getUserById("U1001"), 400);
//        Split splits2_2 = new Split(userController.getUserById("U2001"), 100);
//        splits2.add(splits2_1);
//        splits2.add(splits2_2);
//        group.createExpense("Exp1002", "Lunch", 500, splits2, userController.getUserById("U2001"), ExpenseSplitType.NOT_EQUAL);

        for(User user : userController.getUsers()) {
            balanceSheetController.showBalanceSheetOfUser(user);
        }
    }


    public void setupUserAndGroup(){

        //onboard user to splitwise app
        addUsersToSplitwiseApp();

        //create a group by user1
        User user1 = userController.getUserById("U1001");
        groupController.createGroup("Outing with Friends", "G1001", user1);
    }

    private void addUsersToSplitwiseApp(){

        //adding User1
        User user1 = new User("User1", "U1001");

        //adding User2
        User user2 = new User ("User2", "U2001");

        //adding User3
        User user3 = new User ("User3", "U3001");

        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);
    }

}
