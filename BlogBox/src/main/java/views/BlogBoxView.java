/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import boundary.BlogBoxUserFacade;
import entities.BlogBoxUser;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author larsson152
 */
@ManagedBean (name="bbView")
@SessionScoped
public class BlogBoxView {

    @EJB
    private BlogBoxUserFacade blogBoxUserFacade;
    private BlogBoxUser user;

    /**
     * Creates a new instance of BlogBoxView
     */
    public BlogBoxView() {
        this.user = new BlogBoxUser();
    }

    public BlogBoxUser getUser() {

        return user;
    }

    public String updateUser(String name) {

        List<BlogBoxUser> users = blogBoxUserFacade.findAll();

        for (BlogBoxUser user : users) {
            if (user.getName().equals(name)) {
                this.user = user;
                return "userpage";
            }
        }
        return "index";

    }

    public int getNumberOfUsers() {
        return blogBoxUserFacade.findAll().size();
    }

    public String createUser() {
        List<BlogBoxUser> users = blogBoxUserFacade.findAll();
        for (BlogBoxUser usr : users) {
            if (usr.getName().equals(user.getName())) {
                return "index";
            }
        }

        blogBoxUserFacade.create(user);
        return "userpage";
    }

    public List<BlogBoxUser> getAllUsers() {
        return blogBoxUserFacade.findAll();
    }
}
