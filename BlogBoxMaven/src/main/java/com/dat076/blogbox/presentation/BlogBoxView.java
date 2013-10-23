/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dat076.blogbox.presentation;

import com.dat076.blogbox.boundary.BlogBoxUserFacade;
import com.dat076.blogbox.entities.BlogBoxUser;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Patrik Larsson
 * Takes care of the session that has to do with BlogBoxUser
 */
@Named
@SessionScoped
public class BlogBoxView implements Serializable{

    @EJB
    private BlogBoxUserFacade blogBoxUserFacade;
    private BlogBoxUser user;

    /**
     * Creates a new instance of MessageView
     */
    public BlogBoxView() {
        this.user = new BlogBoxUser();
    }
    //retuns the user
    public BlogBoxUser getUser() {
        return user;
    }
    //gives the BlogBoxView a new user
    public void setUser(BlogBoxUser user) {
        this.user = user;
    }
    //returns true if the user has its name/password set
    public boolean hasUser() {
        return user.isNotNull();
    }
    //returns how many users in database
    public int getNumberOfUsers() {
        return blogBoxUserFacade.findAll().size();
    }
    //returns all users in database
    public List<BlogBoxUser> getUsers() {
        return blogBoxUserFacade.findAll();
    }
    //logins on a user with admin rights
    public String loginUser(BlogBoxUser tempuser) {
        this.user = tempuser;
        List<BlogBoxUser> users = blogBoxUserFacade.findAll();
        for (BlogBoxUser temp : users) {
            if (temp.getName().equals(user.getName()) && temp.getPassword().equals(user.getPassword())) {
                user = temp;
                return "user?faces-redirect=true&includeViewParams=true";
            }
        }
        user.setName(null);
        user.setPassword(null);
        return "index?faces-redirect=true&includeViewParams=true";
    }
    //logout user and removes admin rights
    public String logoutUser() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpSession.invalidate();
        user.setName(null);
        user.setPassword(null);
        return "index?faces-redirect=true&includeViewParams=true";
    }
}
