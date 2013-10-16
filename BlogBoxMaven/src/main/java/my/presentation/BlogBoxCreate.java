/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.BlogBoxUserFacade;
import entities.BlogBoxUser;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author Patrik Larsson
 */
@ManagedBean(name = "BlogBoxCreate")
@RequestScoped
public class BlogBoxCreate {

    @EJB
    private BlogBoxUserFacade blogBoxUserFacade;
    private BlogBoxUser user;

    /**
     * Creates a new instance of MessageView
     */
    public BlogBoxCreate() {
        this.user = new BlogBoxUser();
    }

    public BlogBoxUser getUser() {
        return user;
    }

    public boolean hasUser() {
        return user.isNotNull();
    }

    public int getNumberOfUsers() {
        return blogBoxUserFacade.findAll().size();
    }

    public String createUser() {
        for (BlogBoxUser temp : blogBoxUserFacade.findAll()) {
            if (temp.getName().equals(user.getName()) && temp.getPassword().equals(user.getPassword())) {

                return "index";
            }
        }
        this.blogBoxUserFacade.create(user);
        return "index";
    }
}