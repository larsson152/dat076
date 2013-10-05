/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.hajo.blog.core;

import java.util.ArrayList;

/**
 *
 * @author Andreas
 */
public class Blog {
    
    private ArrayList<BlogPost> blogPosts;
    private java.util.Calendar calendar;
    
    public Blog() {
        blogPosts = new ArrayList<>();
        
    }

    public ArrayList<BlogPost> getBlogPosts() {
        return blogPosts;
    }
    
    public void newBlogPost(String message) {
        blogPosts.add(new BlogPost(message));
        
    }
}
