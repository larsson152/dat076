package com.dat076.blogbox.core;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Shop is a container for other containers
 * NOTE: Uses Java 1.7
 *
 * @author hajo
 */
public class BlogBox implements IBlogBox {

    
    private final IUserRegistry userRegistry;

    public BlogBox(String puName) {
        Logger.getAnonymousLogger().log(Level.INFO, "Shop alive {0}", this.hashCode());
        userRegistry = new UserRegistry(puName);
    }

    @Override
    public IUserRegistry getUserRegistry() {
        return userRegistry;
    }


}
