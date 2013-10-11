
package com.dat076.blogbox.core;

import com.dat076.blogbox.core.BlogPost;
import com.dat076.blogbox.utils.IDAO;
import java.util.List;

/**
 * Interface to BlogCatalogue
 * @author Gustav & Andreas
 */
public interface IBlogCatalogue extends IDAO<BlogPost,String> {

    public List<BlogPost> getByName(String name);
     
}
