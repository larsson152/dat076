/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dat076.blogbox.boundary;

import com.dat076.blogbox.entities.BlogPost;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author larsson152
 * is a EntityManager for BlogPost
 */
@Stateless
public class BlogPostFacade extends AbstractFacade<BlogPost> {
    @PersistenceContext(unitName = "BlogBoxPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BlogPostFacade() {
        super(BlogPost.class);
    }
    
}
