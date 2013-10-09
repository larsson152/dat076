/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dat076.blogbox.model;

import com.dat076.blogbox.User;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author larsson152
 */
@Named
@ApplicationScoped
public class BlogboxModelBean {

    private ArrayList<User> users;

    @PostConstruct
    public void init() {
        users = new ArrayList();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
