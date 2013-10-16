/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.BlogPostFacade;
import entities.Blog;
import entities.BlogPost;
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
    
    public List getAllBlogPosts(){
        return blogPostFacade.findAll();
    }
    
    public int getNumberOfBlogPost(){
        return blogPostFacade.findAll().size();
    }
    
     public List<BlogPost> getBlogPostsOnBlog(Blog blog) {
        blogPost.setBlog(blog);
        List<BlogPost> blogPosts = new ArrayList<BlogPost>();
        List<BlogPost> tempList = blogPostFacade.findAll();
        for (BlogPost temp : tempList) {
            if (temp.getBlog().getId().equals(blogPost.getBlog().getId())) {
                blogPosts.add(temp);
                System.out.println("Blogs " + temp.getTitle());
            }
            
        }
        return blogPosts;
    }
    
    public int getNumberOfPostOnBlog(){
        List<BlogPost>blogs = blogPostFacade.findAll();
        int k=0;
      for(BlogPost temp: blogs){
          if(temp.getBlog().getId().equals(blogPost.getBlog().getId())){
              k++;
              System.out.println("Mes "+temp.getMessage());
          }
              
      }
        return k ;
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
