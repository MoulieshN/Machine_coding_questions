package org.example.controller;

import org.example.models.Group;
import org.example.models.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    private List<Group> groups = new ArrayList<>();
    public void addGroup(Group group) {
        groups.add(group);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public Group getGroupById(String groupId) {
        for (Group group : groups) {
            if (group.getGroupID().equals(groupId)) {
                return group;
            }
        }
        return null; // or throw an exception if group not found
    }

    public void createGroup(String groupName, String groupID, User createdBy) {
        Group group = new Group(groupName, groupID);
        group.addMember(createdBy);
        groups.add(group);
    }
}
