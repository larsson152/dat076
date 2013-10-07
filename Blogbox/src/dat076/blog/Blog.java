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
public class Blog {
    
    private ArrayList<BlogPost> blogPosts;
    private java.util.Calendar calendar;
    private String blogName;
    
    public Blog(String blogName) {
        this.blogPosts = new ArrayList<>();
        this.blogName = blogName;
    }

    public ArrayList<BlogPost> getBlogPosts() {
        return blogPosts;
    }
    
    public void newBlogPost(String message) {
        blogPosts.add(new BlogPost(message));
        
    }
    
    public BlogPost getLatestPost(){
        BlogPost returnPost=blogPosts.get(0);
        for(int i=1;i<blogPosts.size();i++){
           if(returnPost.getDate().compareTo(blogPosts.get(i).getDate())<0)
               returnPost=blogPosts.get(i);            
        }
        
        return returnPost;
    }
    
    
     public ArrayList<BlogPost> getPostByDate(java.util.Date date){
        
        ArrayList<BlogPost> datePosts = new ArrayList<>();
        
        for(int i=0;i<blogPosts.size();i++){
            if(blogPosts.get(i).getDate().compareTo(date)==0){
                datePosts.add(blogPosts.get(i));
            }
        }
        
        return datePosts;
    }
     
     public String getBlogName()
     {
         return blogName;
     }
}
