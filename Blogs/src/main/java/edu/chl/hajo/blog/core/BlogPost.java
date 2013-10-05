/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.hajo.blog.core;

import java.util.*;

/**
 *
 * @author Andreas
 */
public class BlogPost {
    
   private String message;
   private java.util.Date date;
   
   public BlogPost(){
       
   }
    
   public BlogPost(String message){
       this.message = message;
   }
    
   public String getMessage(){
       return message;
   }
   
   public java.util.Date getDate(){
       return date;
   }
   
}
