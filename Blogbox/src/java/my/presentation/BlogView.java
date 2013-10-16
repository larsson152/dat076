/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.BlogFacade;
import entities.Blog;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;



/**
 *
 * @author Patrik Larsson
 */
@ManagedBean(name="BlogView")
@SessionScoped
public class BlogView {
    
    @EJB
    private BlogFacade blogFacade;
    private Blog blog;

    /**
     * Creates a new instance of BlogView
     */
    public BlogView() {
        this.blog = new Blog();
    }

    public Blog getBlog() {
        return blog;
    }
    
    public int getNumberOfBlogs(){
        return blogFacade.findAll().size();
    }
    
    public String createBlog(){
        this.blogFacade.create(blog);
        return "blog";
    }
}
