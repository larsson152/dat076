/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dat076.blogbox.boundary;

import com.dat076.blogbox.entities.BlogBoxUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author larsson152
 */
@Stateless
public class BlogBoxUserFacade extends AbstractFacade<BlogBoxUser> {
    @PersistenceContext(unitName = "BlogBoxPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BlogBoxUserFacade() {
        super(BlogBoxUser.class);
    }
    
}
