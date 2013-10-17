/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dat076.blogbox.presentation;

import com.dat076.blogbox.boundary.BlogFacade;
import com.dat076.blogbox.entities.Blog;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;



/**
 *
 * @author Patrik Larsson
 */
@Named
@SessionScoped
public class BlogView implements Serializable {
    
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
