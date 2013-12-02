package Test;

import com.dat076.blogbox.entities.Blog;
import com.dat076.blogbox.entities.BlogBoxUser;
import com.dat076.blogbox.entities.BlogPost;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andreas
 */
public class JUnitTest {
    
    
    private ArrayList<BlogBoxUser> users;
    private ArrayList<Blog> blogs;
    private ArrayList<BlogPost> posts;

    @Before
    public void setUp() {
        users = new ArrayList<BlogBoxUser>();
        blogs = new ArrayList<Blog>();
        posts = new ArrayList<BlogPost>();
    }

    @Test
    public void setAndGetUser() {
       BlogBoxUser user = new BlogBoxUser(); 
        
       user.setName("adde");
       user.setPassword("300");
       user.setId((long)1);
       
       users.add(user);
       
       Blog blog = new Blog();
       
       blog.setName("katt");
       blog.setUser(user);
       blog.setId((long)1);
       
       
       blogs.add(blog);
       
       assertTrue(blog.getUser()==user);
       
        Blog blog2 = new Blog();
       
       blog2.setName("katt2");
       blog2.setUser(user);
       blog2.setId((long)2);
       
       blogs.add(blog2);
       
       BlogBoxUser user2 = new BlogBoxUser(); 
        
       user2.setName("hen");
       user2.setPassword("770");
       user2.setId((long)2);
       
       Blog blog3 = new Blog();
       
       blog3.setName("katt3");
       blog3.setUser(user2);
       blog3.setId((long)3);
       
       blogs.add(blog3);
        
       int nr =0;

       for(int i=0;i<blogs.size();i++){

           if(blogs.get(i).getUser().getId().equals(user.getId()))
               nr++;
       }
       
       assertTrue(nr==2);
    }
}