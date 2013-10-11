package com.dat076.blogbox.core;

import com.dat076.blogbox.utils.AbstractEntity;
import javax.persistence.Entity;

/**
 * A Blogpost
 * @author Henrik Merlander
 */
@Entity
public class BlogPost extends AbstractEntity {

    private String title;
    private String message;

    public BlogPost() {
    }

    public BlogPost(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }
     
    @Override
    public String toString() {
        return "BlogPost{" + "title=" + title + ", message=" + message + '}';
    }
}
