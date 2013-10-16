package com.dat076.blogbox.core;

import com.dat076.blogbox.core.BlogPost;
import com.dat076.blogbox.utils.AbstractDAO;
import java.util.ArrayList;
import java.util.List;

public final class BlogCatalogue extends AbstractDAO<BlogPost, String>
        implements IBlogCatalogue {

    private BlogCatalogue(String puName) {
        super(BlogPost.class, puName);
    }

    // Factory method
    public static IBlogCatalogue newInstance(String puName) {
        return new BlogCatalogue(puName);
    }

    @Override
    public List<BlogPost> getByName(String title) {
        List<BlogPost> found = new ArrayList<>();
        for (BlogPost p : getRange(0, getCount())) {
            if (p.getTitle().equals(title)) {
                found.add(p);
            }
        }
        return found;
    }
}
