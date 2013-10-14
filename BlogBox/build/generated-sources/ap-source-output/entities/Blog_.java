package entities;

import entities.BlogBoxUser;
import entities.BlogPost;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-14T16:16:55")
@StaticMetamodel(Blog.class)
public class Blog_ { 

    public static volatile SingularAttribute<Blog, Long> id;
    public static volatile SingularAttribute<Blog, String> name;
    public static volatile ListAttribute<Blog, BlogPost> blogPosts;
    public static volatile SingularAttribute<Blog, BlogBoxUser> user;

}