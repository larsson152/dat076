/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.BlogBoxUserFacade;
import entities.BlogBoxUser;
import java.util.List;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.*;
import javax.inject.Inject;

/**
 *
 * @author Patrik Larsson
 */
@ManagedBean(name = "BlogBoxView")
@SessionScoped
public class BlogBoxView {

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
        System.out.println(" 1  " + user.getName() + " 2  " + user.getEmail() + " TTT  " + user.getId());
        List<BlogBoxUser> users = blogBoxUserFacade.findAll();
        for (BlogBoxUser temp : users) {
            if (temp.getName().equals(user.getName()) && temp.getEmail().equals(user.getEmail())) {
                user = temp;
                return "user";
            }
        }
        user.setName(null);
        user.setEmail(null);
        return "index";
    }

    public String logoutUser() {
        this.user.setName(null);
        this.user.setEmail(null);
        return "index";
    }
}
