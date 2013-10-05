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
public class User {
    
    private String name;
    private ArrayList<Blog> blogs;
    
    public User(){
        
    }
    
    public User(String name){
        this.name=name;
        blogs = new ArrayList<>();
    }
    
    public String getName(){
        return name;
    }
    
    public  ArrayList<Blog> getBlogs(){
        return blogs;
    }
}
