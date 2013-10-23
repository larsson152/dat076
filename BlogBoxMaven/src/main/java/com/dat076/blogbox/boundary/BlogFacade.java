/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dat076.blogbox.boundary;

import com.dat076.blogbox.entities.Blog;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author larsson152
 * is a EntityManager for Blog
 */
@Stateless
public class BlogFacade extends AbstractFacade<Blog> {
    @PersistenceContext(unitName = "BlogBoxPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BlogFacade() {
        super(Blog.class);
    }
    
}
