/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.hajo.blog.core;

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

    private TheBlog theBlog;

    public TestBlog() {
    }

    @Before
    public void setUp() {
        theBlog = new TheBlog();
    }
    @Test
    public void testAddUsers() {

        theBlog.addNewUser("adde");
        assertTrue(theBlog.getUsers().get(0).getName().equals("adde"));
        assertTrue(theBlog.getUsers().size() == 1);
        theBlog.addNewUser("pizzahut");
        assertTrue(theBlog.getUsers().get(1).getName().equals("pizzahut"));
        assertTrue(theBlog.getUsers().size() == 2);
        theBlog.addNewUser("adde");
        assertTrue(theBlog.getUsers().size() == 2);

    }
}