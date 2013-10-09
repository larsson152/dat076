/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dat076.blogbox;

import com.dat076.blogbox.Blog;
import com.dat076.blogbox.Blogbox;
import com.dat076.blogbox.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andreas
 */
public class TestBlog {

    private Blogbox blogbox;

    public TestBlog() {
    }

    @Before
    public void setUp() {
        blogbox = new Blogbox();
    }
    @Test
    public void testAddUsers() {

        blogbox.addNewUser("adde");
        assertTrue(blogbox.getUserByName("Adde").getName().equals("adde"));
        assertTrue(blogbox.getUsers().size() == 1);
        blogbox.addNewUser("pizzahut");
        assertTrue(blogbox.getUserByName("PiZZahuT").getName().equals("pizzahut"));
        assertTrue(blogbox.getUsers().size() == 2);
        blogbox.addNewUser("Adde");
        assertTrue(blogbox.getUsers().size() == 2);
    }
    
    @Test
    public void testBlogPost()
    {
        blogbox.addNewUser("Gustav");
        User tempUser = blogbox.getUserByName("Gustav");
        assertTrue(tempUser.getName().equals("Gustav"));
        tempUser.createBlog("Gustavs Hörna");
        Blog tempBlog = tempUser.getBlogByName("Gustavs Hörna");
        assertTrue(tempBlog.getBlogName().equals("Gustavs Hörna"));
    }
    
}