/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import boundary.BlogBoxUserFacade;
import boundary.BlogFacade;
import entities.Blog;
import entities.BlogBoxUser;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author larsson152
 */
@ManagedBean
@RequestScoped
public class BlogBoxUserView {

    @EJB
    private BlogBoxUserFacade blogBoxUserFacade;
    @EJB
    private BlogFacade blogFacade;
    private Blog blog;

    /**
     * Creates a new instance of BlogBoxUserView
     */
    public BlogBoxUserView() {
        this.blog = new Blog();
    }

    public Blog getBlog() {
        return blog;
    }

    public int getNumberOfBlogs() {
        return blogFacade.findAll().size();
    }

    public String createBlog(String name) {
        List<BlogBoxUser> users = blogBoxUserFacade.findAll();

        for (BlogBoxUser tmpUser : users) {
            System.out.println("tmpUser: "+tmpUser.getName());
            System.out.println("user: "+name);
            if (tmpUser.getName().equals(name)){
                this.blog.setUser(tmpUser);
                blogFacade.create(blog);
                return "blog";
            }
        }


        System.out.println("Tidigare användare hittades ej!");
        return "userpage";

    }
}
