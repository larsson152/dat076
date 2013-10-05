package edu.chl.hajo.blog.core;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andreas
 */
public class TheBlog {

    private ArrayList<User> users;

    public TheBlog() {
        users = new ArrayList<>();

    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public boolean addNewUser(String name) {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                return false;
            }
        }
        users.add(new User(name));
        return true;
    }
}
