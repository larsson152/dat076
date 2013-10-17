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

    public BlogBoxUser getUser() {
        return user;
    }

    public void setUser(BlogBoxUser user) {
        this.user = user;
    }

    public boolean hasUser() {
        return user.isNotNull();
    }

    public int getNumberOfUsers() {
        return blogBoxUserFacade.findAll().size();
    }

    public List<BlogBoxUser> getUsers() {
        return blogBoxUserFacade.findAll();
    }

    public String loginUser(BlogBoxUser tempuser) {
        this.user = tempuser;
        List<BlogBoxUser> users = blogBoxUserFacade.findAll();
        for (BlogBoxUser temp : users) {
            if (temp.getName().equals(user.getName()) && temp.getPassword().equals(user.getPassword())) {
                user = temp;
                return "user";
            }
        }
        user.setName(null);
        user.setPassword(null);
        return "index";
    }

    public String logoutUser() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpSession.invalidate();
        user.setName(null);
        user.setPassword(null);
        return "index";
    }
}
