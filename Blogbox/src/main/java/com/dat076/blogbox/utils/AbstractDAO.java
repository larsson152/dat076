package com.dat076.blogbox.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * A container for entities, base class for OrderBook, ProductCatalogue,
 * CustomerRegistry The fundamental common operations are here (CRUD).
 *
 * T is type for items in container K is type of id (primary key)
 *
 * @author hajo
 */
public abstract class AbstractDAO<T, K> implements IDAO<T, K> {
    

    private EntityManagerFactory emf;
    private final Class<T> clazz;
    
    protected AbstractDAO(Class<T> clazz, String puName) {
        this.clazz = clazz;
        emf = Persistence.createEntityManagerFactory(puName);
    }

    @Override
    public void add(T t) {
        
        EntityManager em = null;
        try {
            // Create ...
            em = emf.createEntityManager();
            // Must handle transaction, this is application managed 
            // transaction (RESOURCE_LOCAL)
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();  // ... and destroy
            }
        }
        
    }

    @Override
    public void remove(K id) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            T t = em.getReference(clazz, id);
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public T update(T t) {
        T t1 = null;
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            t1 = em.merge(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return t1;
    }

    @Override
    public T find(K id) {
        EntityManager em = emf.createEntityManager();
        T t = em.find(clazz, id);
        return t;
    }

    @Override
    public List<T> getRange(int first, int nItems) {
        // From inclusive, to exclusive
        EntityManager em = emf.createEntityManager();
        List<T> products = new ArrayList<>();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(clazz));
            Query q = em.createQuery(cq);
            q.setMaxResults(nItems);
            q.setFirstResult(first);
            products.addAll(q.getResultList());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return products;
    }

    @Override
    public int getCount() {
        EntityManager em = emf.createEntityManager();
        int count = -1;
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<T> rt = cq.from(clazz);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            count = ((Long) q.getSingleResult()).intValue();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return count;
    }

    public void sort(Comparator<T> comp) {
    }
}
