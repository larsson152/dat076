/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entities.BlogPost;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author larsson152
 */
@Stateless
public class BlogPostFacade extends AbstractFacade<BlogPost> {
    @PersistenceContext(unitName = "SimpleEE6AppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BlogPostFacade() {
        super(BlogPost.class);
    }
    
}
