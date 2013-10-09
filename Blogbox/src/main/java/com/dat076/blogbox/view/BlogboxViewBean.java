/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dat076.blogbox.view;

import com.dat076.blogbox.User;
import com.dat076.blogbox.model.BlogboxModelBean;
import java.util.ArrayList;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author larsson152
 */
@Named
@RequestScoped
public class BlogboxViewBean {
    
    @Inject
    private BlogboxModelBean blogboxModelBean;
    private String name;

    public ArrayList<String> getUsers() {

        final ArrayList<String> names = new ArrayList();

        for (User user : blogboxModelBean.getUsers()) {
            names.add(user.getName());
        }

        return names;
    }


    public User getUserByName(String name) {
        for (User user : blogboxModelBean.getUsers()) {
            if (user.getName().toLowerCase().equals(name.toLowerCase())) {
                return user;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
