package com.dat076.blogbox.core;

import com.dat076.blogbox.utils.AbstractDAO;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

/**
 *
 * @author Patrik Larsson
 */

@Named
public final class UserRegistry extends AbstractDAO<User, Long> implements IUserRegistry {

   
    
    public UserRegistry(String puName) {
        super(User.class, puName);
       
    }
    
    @Override
    public List<User> getByName(String name) {
        List<User> found = new ArrayList<>();
        for (User u : getRange(0, getCount())) {
            if (u.getName().equals(name)) {
                found.add(u);
            }
        }
        return found;
    }
}
