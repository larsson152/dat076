package entities;

import entities.Blog;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-14T16:16:55")
@StaticMetamodel(BlogPost.class)
public class BlogPost_ { 

    public static volatile SingularAttribute<BlogPost, Long> id;
    public static volatile SingularAttribute<BlogPost, String> message;
    public static volatile SingularAttribute<BlogPost, String> title;
    public static volatile SingularAttribute<BlogPost, Blog> blog;

}