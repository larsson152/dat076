package com.dat076.blogbox.core;

import com.dat076.blogbox.utils.IDAO;
import java.util.List;

/**
 * 
 * @author Patrik Larsson
 */
public interface IUserRegistry extends IDAO<User, Long> {

    List<User> getByName(String name);
    
}
