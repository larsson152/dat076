/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dat076.blogbox;

import com.dat076.blogbox.core.BlogBox;
import com.dat076.blogbox.core.IBlogBox;
import com.dat076.blogbox.core.IUserRegistry;
import com.dat076.blogbox.core.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andreas
 */

public class TestBlog {

    static IBlogBox blogbox;
    final static String PU = "blog_pu";
    final static String TEST_PU = "blog_test_embedded_pu";

    @Before // Run before each test
    public void before() {
        blogbox = new BlogBox(PU);
    }

    @Test
    public void testAddUpdateAndRemoveProduct() {
        IUserRegistry ur = blogbox.getUserRegistry();

        User u = new User("adde", "abs@abs.com");
        ur.add(u);
        assertTrue(ur.getCount() == 1);

        User u2 = ur.find(u.getId());
        // Not same transaction
        assertTrue(u2 != u);
        // Equal by value
        assertTrue(u2.equals(u));

        User u1 = new User(u.getId(), "updated", u.getEmail());
        u = ur.update(u1);

        /*
         * Id NOT changed here we have two Products with
         * same id but different state! 
         * Seems to be no single simple solution to this..?!
         */
        assertTrue(u2.equals(u));
        assertFalse(u2.getName().equals(u.getName()));
        assertTrue(ur.getCount() == 1);

        ur.remove(u.getId());
        System.out.println("Test!!!!!!: " + ur.getCount());
        assertTrue(ur.getCount() == 0);
        assertTrue(ur.find(u.getId()) == null);

        // No change in program (but deleted from database)
        assertTrue(u2.equals(u));
        assertFalse(u2.getName().equals(u.getName()));
    }
}