/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dat076.blogbox.presentation;

import com.dat076.blogbox.boundary.BlogFacade;
import com.dat076.blogbox.entities.Blog;
import com.dat076.blogbox.entities.BlogBoxUser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author larsson152
 * Takes care of the session that has to do with Blog
 */
@Named
@SessionScoped
public class BlogBoxUserView implements Serializable {
    
    @EJB
    private BlogFacade blogFacade;
    private Blog blog;

    /**
     * Creates a new instance of BlogBoxUserView
     */
    public BlogBoxUserView() {
        this.blog = new Blog();
    }
    //returns the blog
    public Blog getBlog() {
        return blog;
    }
    //gives the BlogBoxUserView a new blog
    public void setBlog(Blog blog) {
        this.blog = blog;
    }
    
    //returns all blogs in database
    public List getAllUsersBlogs() {
        return blogFacade.findAll();
    }
    //retuns all blogs linked to a user
    public List<Blog> getBlogsOnUser(BlogBoxUser user) {
        blog.setUser(user);
        List<Blog> blogs = new ArrayList<Blog>();
        for (Blog temp :  blogFacade.findAll()) {
            if (temp.getUser().getId().equals(user.getId())) {
                blogs.add(temp);
            }
            
        }
        return blogs;
    }
    //returns how many blogs in database
    public int getNumberOfBlogs() {
        return blogFacade.findAll().size();
    }
    //retuns how many blog linked to a user 
    public int getNumberOfBlogsOnUser() {
    
        List<Blog> blogs = blogFacade.findAll();
        int k = 0;
        for (Blog temp : blogs) {
            if (temp.getUser().getId().equals(blog.getUser().getId())) {
                k++;
            }
            
        }
        return k;
    }
    //logins to a blog with admin rights
    public String loginBlog(Blog tempBlog,BlogBoxUser user) {

        this.blog = tempBlog;
        blog.setUser(user);
        List<Blog> blogs = getBlogsOnUser(blog.getUser());
        for (Blog temp : blogs) {
            if (temp.getName().equals(blog.getName())) {                     
                blog = temp;
                return "blog?faces-redirect=true&includeViewParams=true";
            }
        }        
        return "user?faces-redirect=true&includeViewParams=true";
    }
    //enters a blog with view only rights
     public String enterBlog(Blog tempBlog,BlogBoxUser user) {

        this.blog = tempBlog;
        blog.setUser(user);
        return "viewBlogPosts?faces-redirect=true&includeViewParams=true";
    }
}
