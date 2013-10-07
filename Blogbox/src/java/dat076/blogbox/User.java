/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dat076.blog;

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
}
