package com.dat076.blogbox;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andreas
 */
public class Blogbox {

    private ArrayList<User> users;

    public Blogbox() {
        users = new ArrayList();

    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public boolean addNewUser(String name) {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                return false;
            }
        }
        users.add(new User(name));
        return true;
    }
    
    public User getUserByName(String name)
    {
         for (User user: users) {
            if (user.getName().toLowerCase().equals(name.toLowerCase())) {
                return user;
            }
        }
        return null;
    }
    
}
