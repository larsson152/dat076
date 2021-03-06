/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dat076.blogbox.presentation;

import com.dat076.blogbox.boundary.BlogBoxUserFacade;
import com.dat076.blogbox.entities.BlogBoxUser;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author Patrik Larsson
 * Takes care of the request that has to do with BlogBoxUser
 */
@Named
@RequestScoped
public class BlogBoxCreate {

    @EJB
    private BlogBoxUserFacade blogBoxUserFacade;
    private BlogBoxUser user;
    
    @Inject
    private BlogBoxView blogBoxView;

    /**
     * Creates a new instance of MessageView
     */
    public BlogBoxCreate() {
        this.user = new BlogBoxUser();
    }
    //return the user the requestScope has
    public BlogBoxUser getUser() {
        return user;
    }
    //creates a new user and puts it in a sessionScope
    public String createUser() {
        for (BlogBoxUser temp : blogBoxUserFacade.findAll()) {
            if (temp.getName().equals(user.getName()) && temp.getPassword().equals(user.getPassword())) {

                return "index?faces-redirect=true&includeViewParams=true";
            }
        }
        this.blogBoxUserFacade.create(user);
        blogBoxView.setUser(user);
        return "user?faces-redirect=true&includeViewParams=true";
    }
}
