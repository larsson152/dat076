/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dat076.blogbox;

import com.dat076.blogbox.Blog;
import java.util.ArrayList;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Andreas
 */

@ManagedBean(name = "user", eager = true)
@RequestScoped
public class User {
    
    private String name;
    private ArrayList<Blog> blogs;
    
    public User(){
        
    }
    
    public User(String name){
        this.name=name;
        blogs = new ArrayList();
    }
    
    public String getName(){
        return name;
    }
    
    public  ArrayList<Blog> getBlogs(){
        return blogs;
    }
    
    public void createBlog(String blogName){
        blogs.add(new Blog(blogName));
    }
    
    public Blog getBlogByName(String name)
    {
        for (Blog blog: blogs) {
            if (blog.getBlogName().toLowerCase().equals(name.toLowerCase())) {
                return blog;
            }
        }
        return null;
    }
    
    public void setName(String name){
        this.name = name;
    }
}
