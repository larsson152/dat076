/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.BlogFacade;
import entities.Blog;
import entities.BlogBoxUser;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author larsson152
 */
@Named
@RequestScoped
public class BlogBoxUserCreate {
    
    @EJB
    private BlogFacade blogFacade;
    private Blog blog;

    /**
     * Creates a new instance of BlogBoxUserView
     */
    public BlogBoxUserCreate() {
        this.blog = new Blog();
    }
    
    public Blog getBlog() {
        return blog;
    }
    
    public List getAllUsersBlogs() {
        return blogFacade.findAll();
    }
    
    public List<Blog> getBlogsOnUser(BlogBoxUser user) {
        blog.setUser(user);
        List<Blog> blogs = new ArrayList<Blog>();
        List<Blog> tempList = blogFacade.findAll();
        for (Blog temp : tempList) {
            if (temp.getUser().getId().equals(blog.getUser().getId())) {
                blogs.add(temp);
                System.out.println("Blogs " + temp.getName());
            }
            
        }
        return blogs;
    }
    
    public int getNumberOfBlogs() {
        return blogFacade.findAll().size();
    }
    
    public int getNumberOfBlogsOnUser() {
        List<Blog> blogs = blogFacade.findAll();
        int k = 0;
        for (Blog temp : blogs) {
            if (temp.getUser().getId().equals(blog.getUser().getId())) {
                k++;
                System.out.println("Blogs " + temp.getName());
            }
            
        }
        return k;
    }
    
    public String createBlog(BlogBoxUser user) {
        
        blog.setUser(user);
        
        List<Blog> blogs = getBlogsOnUser(user);
        for (Blog temp : blogs) {
            if (temp.getName().equals(blog.getName()) || blog.getName().equals("")) {            
                
                return "user";
            }
        }        
        blogFacade.create(blog);
        return "user";
    }
}
