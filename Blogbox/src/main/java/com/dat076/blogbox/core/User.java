package com.dat076.blogbox.core;

import com.dat076.blogbox.utils.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 *
 * @author Patrik Larsson
 */
@Entity
@Table //(name="User")
public class User extends AbstractEntity  {
    
    private String name;
    @Column(nullable=false)
    private String email;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    public User(Long id, String fname,
            String lname, String email) {
        super(id);
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
