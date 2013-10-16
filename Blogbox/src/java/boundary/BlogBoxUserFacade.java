/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entities.BlogBoxUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author larsson152
 */
@Stateless
public class BlogBoxUserFacade extends AbstractFacade<BlogBoxUser> {
    @PersistenceContext(unitName = "SimpleEE6AppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BlogBoxUserFacade() {
        super(BlogBoxUser.class);
    }
    
}
