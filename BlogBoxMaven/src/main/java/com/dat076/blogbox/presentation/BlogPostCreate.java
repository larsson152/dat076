/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dat076.blogbox.presentation;

import com.dat076.blogbox.boundary.BlogPostFacade;
import com.dat076.blogbox.entities.Blog;
import com.dat076.blogbox.entities.BlogPost;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author Patrik Larsson
 */
@Named
@RequestScoped
public class BlogPostCreate implements Serializable{
    @EJB
    private BlogPostFacade blogPostFacade;
    private BlogPost blogPost;
    @Inject
    private BlogPostView blogPostView;
    /**
     * Creates a new instance of BlogPostView
     */
    public BlogPostCreate() {
        this.blogPost = new BlogPost();
    }
    
    public BlogPost getBlogPost(){
        return blogPost;
    }
    
    public String createBlogPost(Blog blog){
        blogPost.setBlog(blog);
        Calendar cal = Calendar.getInstance();
        blogPost.setPostDate(cal.getTime());
        blogPostFacade.create(blogPost);
        blogPostView.setBlogPost(blogPost);
        return "blog";
    }
}
