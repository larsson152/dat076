/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dat076.blogbox.presentation;

import com.dat076.blogbox.boundary.BlogFacade;
import com.dat076.blogbox.entities.Blog;
import com.dat076.blogbox.entities.BlogBoxUser;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author larsson152
 * Takes care of the request that has to do with Blog
 */
@Named
@RequestScoped
public class BlogBoxUserCreate {

    @EJB
    private BlogFacade blogFacade;
    private Blog blog;
    @Inject
    private BlogBoxUserView blogBoxUserView;

    /**
     * Creates a new instance of BlogBoxUserView
     */
    public BlogBoxUserCreate() {
        this.blog = new Blog();
    }
    //returns the blog 
    public Blog getBlog() {
        return blog;
    }

   //returns a list with all the blogs linked to a user
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
    //creates a new blog and puts it in a sessionScope 
    public String createBlog(BlogBoxUser user) {

        blog.setUser(user);

        List<Blog> blogs = getBlogsOnUser(user);
        for (Blog temp : blogs) {
            if (temp.getName().equals(blog.getName()) || blog.getName().equals("")) {

                return "user?faces-redirect=true&includeViewParams=true";
            }
        }
        blogFacade.create(blog);
        blogBoxUserView.setBlog(blog);
        return "blog?faces-redirect=true&includeViewParams=true";
    }
    
}
